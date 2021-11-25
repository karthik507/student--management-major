package com.college.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.college.entity.User;

public interface UserRepo  extends JpaRepository<User, Integer>{

	Optional<User> findByToken(String token);

	Optional<User> findByEmail(String email);

}
