package com.gino.contractor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gino.contractor.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
