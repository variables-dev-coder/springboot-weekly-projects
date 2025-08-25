package com.munna.bookcatalog.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    @Column(nullable = false, length = 255)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private Role role = Role.USER;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt = LocalDateTime.now();

    // Enum for role
    public enum Role {
        USER, ADMIN
    }

    // --- Getters & Setters ---
    public Integer getId() { 
    	return id; 
    	}
    
    public void setId(Integer id) {
    	this.id = id; 
    	}

    public String getName() {
    	return name; 
    	}
    
    public void setName(String name) { 
    	this.name = name; 
    	}

    public String getEmail() {
    	return email; 
    	}
    
    public void setEmail(String email) {
    	this.email = email; 
    	}

    public String getPassword() {
    	return password; 
    	}
    
    public void setPassword(String password) {
    	this.password = password;
    	}

    public Role getRole() {
    	return role; 
    	}
    
    public void setRole(Role role) { 
    	this.role = role; 
    	}

    public LocalDateTime getCreatedAt() {
    	return createdAt;
    	}
    
    public void setCreatedAt(LocalDateTime createdAt) {
    	this.createdAt = createdAt; 
    	}
}