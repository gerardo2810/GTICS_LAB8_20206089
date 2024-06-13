package com.example.clase9webservice.repository;

import com.example.clase9webservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}