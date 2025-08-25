package com.munna.bookcatalog.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false, length = 255)
    private String author;

    @Column(length = 100)
    private String genre;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "published_year")
    private Integer publishedYear;

    // --- Getters & Setters ---
    public Integer getId() { 
    	return id; 
    	}
    
    public void setId(Integer id) {
    	this.id = id;
    	}

    public String getTitle() { 
    	return title; 
    	}
    
    public void setTitle(String title) {
    	this.title = title;
    	}

    public String getAuthor() {
    	return author; 
    	}
    
    public void setAuthor(String author) {
    	this.author = author;
    	}

    public String getGenre() {
    	return genre; 
    	}
    
    public void setGenre(String genre) {
    	this.genre = genre; 
    	}

    public BigDecimal getPrice() { 
    	return price; 
    	}
    
    public void setPrice(BigDecimal price) {
    	this.price = price; 
    	}

    public Integer getPublishedYear() {
    	return publishedYear;
    	}
    
    public void setPublishedYear(Integer publishedYear) {
    	this.publishedYear = publishedYear; 
    	}
}
