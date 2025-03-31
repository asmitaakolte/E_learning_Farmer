package com.farmers.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.elearning.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByCategoryIn(List<String> interestCategories);

}
