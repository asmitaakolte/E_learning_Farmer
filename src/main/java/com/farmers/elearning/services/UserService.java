package com.farmers.elearning.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.farmers.elearning.model.User;
import com.farmers.elearning.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // @Autowired
    // private PasswordEncoder passwordEncoder;


    public User registerUser(String username, String email, String password) {
        if (userRepository.existsByUsername(username)) {
            throw new RuntimeException("Username already taken");
        }
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);  // Encode password
        return userRepository.save(user);
    }

    public String loginUser(String username, String password) {

        User user = userRepository.findByUsername(username);
        if (user.getUsername().equals(null)){
          throw new RuntimeException("User not found");
        }         

        if (password.equals(user.getPassword())) {
            return "Login successful!";
        } else {
            throw new RuntimeException("Invalid username or password");
        }
    }

    public Object getUserProfile() {
        return "User profile data";
    }

    public Object updateUserProfile(User updatedUser) {
        return "User profile updated";
    }
}
