package com.gino.contractor.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gino.contractor.entities.Role;;


/**
 * This interface must be created to relate the object into database for each entity
 * 
 * @author gino.ruperez
 *
 */
public interface RoleRepository extends JpaRepository<Role, Integer> {

	
}
