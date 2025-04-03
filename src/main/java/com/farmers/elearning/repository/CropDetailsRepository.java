package com.farmers.elearning.repository;

import com.farmers.elearning.model.CropDetails;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CropDetailsRepository extends JpaRepository<CropDetails, Long> {
    // JPA provides findAll() to get all crop records
}
