package com.farmers.elearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.farmers.elearning.services.DashboardService;
import com.farmers.elearning.utils.PersonalizedFeedDTO;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/personalized-feed/{userId}")
    public ResponseEntity<PersonalizedFeedDTO> getPersonalizedFeed(@PathVariable Long userId) {
        // Fetching personalized courses and webinars for the user
        PersonalizedFeedDTO feed = dashboardService.getPersonalizedFeed(userId);
        return ResponseEntity.ok(feed);
    }
}
