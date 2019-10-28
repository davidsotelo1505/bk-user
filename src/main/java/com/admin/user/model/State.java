package com.admin.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SAA_STATE")
public class State implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2950780816039758783L;
	
	@Id
	@Column(name = "id", unique = true, nullable = false)
	@SequenceGenerator(name = "state_seq", sequenceName = "state_seq", allocationSize = 1, initialValue = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "state_seq")
	private Long id;
	@Column
	private String name;
	@Column
	private String description;
	
	
	public State() {
		super();
		// TODO Auto-generated constructor stub
	}
	public State(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return new com.google.gson.Gson().toJson(this);
	}
	
	
}
