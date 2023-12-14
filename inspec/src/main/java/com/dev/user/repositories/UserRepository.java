package com.dev.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
