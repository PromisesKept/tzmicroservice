package com.example.usersubscription.repository;

import com.example.usersubscription.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
