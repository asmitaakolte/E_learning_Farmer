package com.farmers.elearning.controller;

import com.farmers.elearning.model.Crop;
import com.farmers.elearning.model.User;
import com.farmers.elearning.model.YouTube;
import com.farmers.elearning.model.Article;
import com.farmers.elearning.model.Course;
import com.farmers.elearning.repository.UserRepository;
import com.farmers.elearning.repository.CropRepository;
import com.farmers.elearning.repository.YoutubeRepository;
import com.farmers.elearning.repository.ArticleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CropRepository cropRepository;

    @Autowired
    private YoutubeRepository youtubeRepository;

    @Autowired
    private ArticleRepository articleRepository;


    // ✅ Get All Users
    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // ✅ Get User by ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // ✅ Create New User
    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    // ✅ Update User Details
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setUsername(userDetails.getUsername());
            user.setPassword(userDetails.getPassword());
            user.setEmail(userDetails.getEmail());
            user.setFullName(userDetails.getFullName());
            user.setAge(userDetails.getAge());
            user.setLocation(userDetails.getLocation());
            user.setLanguagePreference(userDetails.getLanguagePreference());
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    // ✅ Delete User by ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    // ✅ Get Recommendations for a User Based on Crops
    @GetMapping("/{id}/recommendations")
    public List<String> getUserRecommendations(@PathVariable Long id) {
        User user = userRepository.findById(id).orElse(null);
        List<String> recommendations = new ArrayList<>();

        if (user != null) {
            List<Crop> cropList = user.getCrops(); // Assume this returns a List<Crop>
            Set<Crop> cropSet = new HashSet<>(cropList);
            for (Crop crop : cropSet) {
                List<YouTube> youtubeLinks = youtubeRepository.findByCropId(crop.getId());
                List<Article> articleLinks = articleRepository.findByCropId(crop.getId());

                youtubeLinks.forEach(youtube -> recommendations.add(youtube.getYoutubeLink()));
                articleLinks.forEach(article -> recommendations.add(article.getArticleLink()));
            }
        }
        return recommendations;
    }

    // ✅ Assign Crops to User
    @PostMapping("/{id}/crops")
    public User assignCropsToUser(@PathVariable Long id, @RequestBody List<Long> cropIds) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            List<Crop> crops = cropRepository.findAllById(cropIds);
            user.setCrops((crops));
            return userRepository.save(user);
        }
        return null;
    }

}
