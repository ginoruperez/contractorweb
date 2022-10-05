/**
 * 
 */
package com.gino.contractor.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * All command fields in the database will go in this class like id which common to all tables
 * this class is not mapped to database that is why we will use @MappedSuperclass annotation
 * 
 * @author gino.ruperez
 *
 */

@MappedSuperclass
public class AbstractEntity {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)  //this tells to increment the id in the database
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
