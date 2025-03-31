package com.farmers.elearning.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farmers.elearning.model.Course;
import com.farmers.elearning.model.Interest;
import com.farmers.elearning.model.User;
import com.farmers.elearning.model.Webinar;
import com.farmers.elearning.repository.*;
import com.farmers.elearning.utils.PersonalizedFeedDTO;


@Service
public class DashboardService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private WebinarRepository webinarRepository;
    @Autowired
    private UserCourseRepository userCourseRepository;
    @Autowired
    private InterestRepository interestRepository;

    public PersonalizedFeedDTO getPersonalizedFeed(Long userId) {

        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        
        Long id = user.getId();
        // Fetch user's interests     
        List<Interest> interests = interestRepository.findInterestIdsByUserId(user.getId());
        
        //  Query courses and webinars related to user's interests
        //  Ensure that the stream mapping is correct
        List<String> interestCategories = interests.stream().map(interest -> interest.getInterestName()).collect(Collectors.toList());

        // Query courses and webinars related to the user's interests
        List<Course> recommendedCourses = courseRepository.findByCategoryIn(interestCategories);
        List<Webinar> recommendedWebinars = webinarRepository.findByCategoryIn(interestCategories);

        // Filter courses that the user is not enrolled in or completed
        List<Course> filteredCourses = recommendedCourses.stream()
        .filter(course -> !userCourseRepository.existsByUserAndCourseAndIsCompleted(user, course, true))
        .collect(Collectors.toList());

        // Construct the feed response
         PersonalizedFeedDTO feedDTO = new PersonalizedFeedDTO();
        feedDTO.setRecommendedCourses(filteredCourses);
        feedDTO.setRecommendedWebinars(recommendedWebinars);

        return feedDTO;
    }
}
