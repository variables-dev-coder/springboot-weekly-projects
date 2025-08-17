package com.munna.usermanagement.repository;


import com.munna.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
   // Optional<User> findByEmail(String email);
}
