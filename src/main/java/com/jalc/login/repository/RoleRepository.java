package com.jalc.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jalc.login.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
