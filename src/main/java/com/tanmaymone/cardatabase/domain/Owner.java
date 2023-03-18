package com.tanmaymone.cardatabase.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", 
"handler"})
public class Owner {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long OwnerId;
	private String firstname, lastname;
	public Owner() {}
	public long getOwnerId() {
		return OwnerId;
	}
	public void setOwnerId(long ownerId) {
		OwnerId = ownerId;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstName) {
		this.firstname = firstName;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastName) {
		this.lastname = lastName;
	}
	public Owner(String firstName, String lastName) {
		super();
		this.firstname = firstName;
		this.lastname = lastName;
	}
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL,mappedBy="owner")//Defines cascading effect upon deletion or updation. All means all operations are cascaded. 
	//mappedBy owner tells that the Car class has the owner field which is the foreign key for this relationshiop.
	private List<Car> cars;
	public List<Car> getCars() {
		return cars;
	}
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="jet_owner",joinColumns= {@JoinColumn(name="ownerid")},inverseJoinColumns= {@JoinColumn(name="id")})
	private Set<Jet> jets = new HashSet<Jet>();
	public Set<Jet> getJets() {
		return jets;
	}
	public void setJets(Set<Jet> jets) {
		this.jets = jets;
	}
}
