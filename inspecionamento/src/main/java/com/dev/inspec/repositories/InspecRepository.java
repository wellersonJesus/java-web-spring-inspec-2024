package com.dev.inspec.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.inspec.entities.User;

public interface InspecRepository extends JpaRepository<User, Long> {

}
