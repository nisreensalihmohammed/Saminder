package com.home.reminder.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class APPOINTMENT_REMINDER {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private String type;
	private Timestamp timestamp;
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
	public APPOINTMENT_REMINDER() {
		
	}

	public APPOINTMENT_REMINDER(String type) {
		super();
		this.type = type;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	@PrePersist
	void preInsert() {
		if (this.timestamp == null) {
			this.timestamp = new Timestamp(System.currentTimeMillis());
		}
	}
}
