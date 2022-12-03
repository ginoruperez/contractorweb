package com.gino.contractor.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

/**
 * This a java bean for Role Entity, each of the property is mapped to role table in Contractor Database
 * 
 * @author Gino Ruperez
 *
 */

@Entity
public class Role extends AbstractEntity {

	private String name;
	@ManyToMany(mappedBy = "roles")
	private Set<User> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}


}