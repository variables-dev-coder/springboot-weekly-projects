package com.munna.usermanagement.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Username is mandatory")
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank(message = "Password is mandatory")
    @Size(min = 6, max = 100)
    private String password;

    @NotBlank(message = "Email is mandatory")
    @Email
    private String email;

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) {
    	this.id = id; 
    	}

    public String getUsername() {
    	return username; 
    	}
    public void setUsername(String username) {
    	this.username = username; 
    }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; 
    }

    public String getEmail() {
    	return email; 
    }
    public void setEmail(String email) { 
    	this.email = email; 
    
    }
    }