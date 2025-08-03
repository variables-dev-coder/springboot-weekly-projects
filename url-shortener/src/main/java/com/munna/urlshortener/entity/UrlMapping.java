package com.munna.urlshortener.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String shortUrl;

    @Column(nullable = false, length = 1000)
    private String originalUrl;

    private String createdAt;

    private int clickCount;  // 💡 Important!
}
