package com.gino.contractor.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Contractor {

	@Id
	private int id;
	private String name;
	private String location;
	private String specialties;
	private int size;
	private float rate;
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

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
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
		return "Contractor [Id=" +" "+  ", name=" + name + ", location=" + location + ", specialties=" + specialties
				+ ", size=" + size + ", rate=" + rate + ", owner=" + owner + "]";
	}

}
