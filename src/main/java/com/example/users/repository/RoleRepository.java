package com.example.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.users.model.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role,Long> {





}
