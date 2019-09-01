package com.home.reminder.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class APPOINTMENT_REMINDER {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "appointment_id", nullable = false)
	private APPOINTMENT appointment;
	
	private Timestamp timestamp;
	
	/**
	 * @return the appointment
	 */
	public APPOINTMENT getAppointment() {
		return appointment;
	}

	/**
	 * @param appointment the appointment to set
	 */
	public void setAppointment(APPOINTMENT appointment) {
		this.appointment = appointment;
	}

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
	
	
	public APPOINTMENT_REMINDER() {
		
	}

	public APPOINTMENT_REMINDER(APPOINTMENT appointment) {
		super();
		this.appointment = appointment;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	@PrePersist
	void preInsert() {
		if (this.timestamp == null) {
			this.timestamp = new Timestamp(System.currentTimeMillis());
		}
	}
}
