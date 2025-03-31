package com.farmers.elearning.repository;

import com.farmers.elearning.model.Article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findByCropId(Long id);
}
