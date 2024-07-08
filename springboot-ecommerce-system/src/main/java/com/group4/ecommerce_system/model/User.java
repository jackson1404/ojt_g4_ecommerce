package com.group4.ecommerce_system.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	private int ph_no;

	@Column(nullable = false)
	private boolean enabled;

	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();
	
	@Embedded
	private Address userAddress;

	@OneToMany(mappedBy = "customerOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Order> orders;

	public User() {
		
	}
	public User(int id, String name, String email, String password, int ph_no, boolean enabled, Set<Role> roles,
			Address userAddress, List<Order> orders) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.ph_no = ph_no;
		this.enabled = enabled;
		this.roles = roles;
		this.userAddress = userAddress;
		this.orders = orders;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPh_no() {
		return ph_no;
	}

	public void setPh_no(int ph_no) {
		this.ph_no = ph_no;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Address getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	

}
