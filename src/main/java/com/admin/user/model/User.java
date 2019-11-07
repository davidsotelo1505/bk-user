package com.admin.user.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "SAA_USER")
public class User implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1294867337631984779L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private Long id;
	@Column
	private String identificationNumber;
	@Column
	private String names;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	@CreationTimestamp
	private Date registerDate;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name="user_roles"
		,joinColumns=@JoinColumn(name="user_id")
		,inverseJoinColumns=@JoinColumn(name="role_id"))
	private Set <Role> roles;
	
	@OneToOne
	@JoinColumn(name = "state_user_id")
	private State stateUser;
	
	
	

	
	public User() {
		super();
		
	}
	public User(String identificationNumber, String names, String username, String password, Date registerDate,
			Set<Role> roles, State stateUser) {
		super();
		this.identificationNumber = identificationNumber;
		this.names = names;
		this.username = username;
		this.password = password;
		this.registerDate = registerDate;
		this.roles = roles;
		this.stateUser = stateUser;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public State getStateUser() {
		return stateUser;
	}
	public void setStateUser(State stateUser) {
		this.stateUser = stateUser;
	}
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
}
