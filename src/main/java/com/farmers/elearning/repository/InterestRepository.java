package com.farmers.elearning.repository;

import com.farmers.elearning.model.Interest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface InterestRepository extends JpaRepository<Interest, Long> {

    @Query(value = "SELECT * FROM elearning.interest i WHERE i.user_id = :userId", nativeQuery = true)
    List<Interest> findInterestIdsByUserId(@Param("userId") Long userId);
}
