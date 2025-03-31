package com.farmers.elearning.utils;

import java.util.List;

import com.farmers.elearning.model.Course;
import com.farmers.elearning.model.Webinar;

public class PersonalizedFeedDTO {
    private List<Course> recommendedCourses;
    private List<Webinar> recommendedWebinars;

    // Getters and Setters
    public List<Course> getRecommendedCourses() {
        return recommendedCourses;
    }

    public void setRecommendedCourses(List<Course> recommendedCourses) {
        this.recommendedCourses = recommendedCourses;
    }

    public List<Webinar> getRecommendedWebinars() {
        return recommendedWebinars;
    }

    public void setRecommendedWebinars(List<Webinar> recommendedWebinars) {
        this.recommendedWebinars = recommendedWebinars;
    }
}
