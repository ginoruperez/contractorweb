package com.gino.contractor.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * This is a Java Bean for Contractor which map to contractor table in Contractor Database
 * 
 * @author Gino Ruperez
 *
 */
@Entity
public class Contractor {

	@Id
	private int id;
	private String name;
	private String location;
	private String specialties;
	private int size;
	private String rate;
	private String owner;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSpecialties() {
		return specialties;
	}

	public void setSpecialties(String specialties) {
		this.specialties = specialties;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Contractor [Id=" + id + ", name=" + name + ", location=" + location + ", specialties=" + specialties
				+ ", size=" + size + ", rate=" + rate + ", owner=" + owner + "]";
	}

}
