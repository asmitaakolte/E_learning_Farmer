package com.farmers.elearning.repository;

import com.farmers.elearning.model.Crop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropRepository extends JpaRepository<Crop, Long> {
}
