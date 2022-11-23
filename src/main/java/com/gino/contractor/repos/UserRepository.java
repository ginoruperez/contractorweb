/**
 * 
 */
package com.gino.contractor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gino.contractor.entities.User;

/**
 * This interface must be created to relate the object into database for each entity
 * 
 * @author gino.ruperez
 *
 */
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// the spring data will be responsible for creating query to look into db thanks to spring data
	// email is a field in the User table, follow the naming convention. 
	User findByEmail(String email);

}
