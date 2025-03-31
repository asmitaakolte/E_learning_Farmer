package com.farmers.elearning.services;

import com.farmers.elearning.model.User;
import com.farmers.elearning.model.Crop;
import com.farmers.elearning.repository.UserRepository;
import com.farmers.elearning.repository.CropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecommendationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CropRepository cropRepository;

    public List<String> getRecommendations(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        List<Crop> crops = user.getCrops();

        // Prepare the recommendations (Youtube Links & Articles)
        List<String> recommendations = new ArrayList<>();
        
        for (Crop crop : crops) {
            if (crop.getYoutubeLinks() != null) {
                crop.getYoutubeLinks().forEach(youtube -> recommendations.add(youtube.getYoutubeLink()));
            }
            if (crop.getArticles() != null) {
                crop.getArticles().forEach(article -> recommendations.add(article.getArticleLink()));
            }
        }

        return recommendations;
    }
}
