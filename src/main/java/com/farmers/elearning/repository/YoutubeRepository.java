package com.farmers.elearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmers.elearning.model.YouTube;

public interface YoutubeRepository extends JpaRepository<YouTube, Long> {

    List<YouTube> findByCropId(Long id);
}
