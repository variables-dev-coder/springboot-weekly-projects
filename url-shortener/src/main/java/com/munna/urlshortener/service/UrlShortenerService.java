package com.munna.urlshortener.service;

import com.munna.urlshortener.entity.UrlMapping;
import com.munna.urlshortener.repository.UrlMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;

@Service
public class UrlShortenerService {

    @Autowired
    private UrlMappingRepository repository;

    private static final String BASE_URL = "http://localhost:8080/";

    public String shortenUrl(String originalUrl) {
        // Check if already exists
        Optional<UrlMapping> existing = repository.findByOriginalUrl(originalUrl);
        if (existing.isPresent()) {
            return BASE_URL + existing.get().getShortUrl();
        }

        // Generate 6-char short code
        String shortCode = generateShortCode();

        // Create new mapping
        UrlMapping urlMapping = UrlMapping.builder()
                .originalUrl(originalUrl)
                .shortUrl(shortCode)
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();

        repository.save(urlMapping);
        return BASE_URL + shortCode;
    }

    public String getOriginalUrl(String shortUrlCode) {
        Optional<UrlMapping> mapping = repository.findByShortUrl(shortUrlCode);
        return mapping.map(UrlMapping::getOriginalUrl).orElse(null);
    }

    // Utility method to generate random 6-char code
    private String generateShortCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        String code;
        do {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 6; i++) {
                sb.append(chars.charAt(random.nextInt(chars.length())));
            }
            code = sb.toString();
        } while (repository.findByShortUrl(code).isPresent());
        return code;
    }
}
