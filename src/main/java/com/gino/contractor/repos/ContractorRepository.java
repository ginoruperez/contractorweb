package com.gino.contractor.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gino.contractor.entities.Contractor;

public interface ContractorRepository extends JpaRepository<Contractor, Integer> {
	
	

	/**
	 * This uses the hibernate or jql, the Query is run against the object entity 
	 * hibernate is responsible for running against database
	 * 
	 * Note importantly that the table name Contractor must be exactly the same with Contractor bean or entity
	 * 
	 * @return List object array
	 */
	@Query("select location, count(location) from Contractor group by location")
	public List<Object[]> findLocationAndLocationCount();

	
	
//	@Query("select id,name,location,specialties,size,rate,owner from Contractor where id = 2 ")
//	public List<Contractor> findByLocation(int id);

}
