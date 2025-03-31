package com.farmers.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.elearning.model.Webinar;

public interface WebinarRepository extends JpaRepository<Webinar, Long>{

    List<Webinar> findByCategoryIn(List<String> interestCategories);

}
