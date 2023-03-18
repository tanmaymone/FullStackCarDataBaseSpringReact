package com.tanmaymone.cardatabase.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Jet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String make, model;
	private int year, capacity;
	public Jet() {}
	public Jet(String make, String model, int year, int capacity, HashSet<Owner> owners) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.capacity = capacity;
		this.owners = owners;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	@ManyToMany(mappedBy="jets")
	private Set<Owner> owners = new HashSet<Owner>();
	public Set<Owner> getOwners() {
		return owners;
	}
	public void setOwners(Set<Owner> owners) {
		this.owners = owners;
	}
}
