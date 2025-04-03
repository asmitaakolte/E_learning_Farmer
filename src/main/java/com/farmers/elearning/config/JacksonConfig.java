// package com.farmers.elearning.config;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// public class JacksonConfig {

//     @Bean
//     public ObjectMapper objectMapper() {
//         ObjectMapper objectMapper = new ObjectMapper();
        
//         // Configure Jackson to fail on unknown properties during deserialization
//         objectMapper.enable(com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

//         // Configure ObjectMapper globally for serializing objects with default settings.
//         // Add custom configuration if needed (e.g., indent output, date format, etc.)
        
//         return objectMapper;
//     }
// }
