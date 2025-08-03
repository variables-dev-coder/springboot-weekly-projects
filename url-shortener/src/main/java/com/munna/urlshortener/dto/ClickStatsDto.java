package com.munna.urlshortener.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClickStatsDto {
    private String shortUrl;
    private String originalUrl;
    private int clickCount;
    private String createdAt;
}
