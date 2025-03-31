package com.farmers.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.elearning.model.Course;
import com.farmers.elearning.model.User;
import com.farmers.elearning.model.UserCourse;

public interface UserCourseRepository extends JpaRepository<UserCourse, Long> {

    boolean existsByUserAndCourseAndIsCompleted(User user, Course course, boolean b);

}
