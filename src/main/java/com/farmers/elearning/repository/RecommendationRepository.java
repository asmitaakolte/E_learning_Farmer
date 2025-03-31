package com.farmers.elearning.repository;

import com.farmers.elearning.model.Recommendation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecommendationRepository extends JpaRepository<Recommendation, Long> {
}
