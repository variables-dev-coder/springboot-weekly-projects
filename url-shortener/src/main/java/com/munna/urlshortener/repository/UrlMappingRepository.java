package com.munna.urlshortener.repository;

import com.munna.urlshortener.entity.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    
    Optional<UrlMapping> findByShortUrl(String shortUrl);

    Optional<UrlMapping> findByOriginalUrl(String originalUrl);
}
