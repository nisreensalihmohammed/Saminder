package com.home.reminder.entities;





import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class APPOINTMENT {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private Date date;
	private String name;
	private Timestamp timestamp;
	@OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "appointment")
    private APPOINTMENT_REMINDER appointmentReminder;
	
	public APPOINTMENT(Date date, String name) {
		super();
		this.date = date;
		this.name = name;
		this.timestamp = new Timestamp(System.currentTimeMillis());
		
	}
	
	@PrePersist
	void preInsert() {
		if (this.timestamp == null) {
			this.timestamp = new Timestamp(System.currentTimeMillis());
		}
		if (this.appointmentReminder == null) {
			this.appointmentReminder = new APPOINTMENT_REMINDER();
			this.appointmentReminder.setAppointment(this);
		}
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the appointmentReminder
	 */
	public APPOINTMENT_REMINDER getAppointmentReminder() {
		return appointmentReminder;
	}

	/**
	 * @param appointmentReminder the appointmentReminder to set
	 */
	public void setAppointmentReminder(APPOINTMENT_REMINDER appointmentReminder) {
		this.appointmentReminder = appointmentReminder;
	}
	
	@Override
	public String toString() {
	    return "{" +
	            "id=" + id +
	            ", date='" + date + '\'' +
	            ", name='" + name + '\'' +
	            ", timestamp=" + timestamp +
	            '}';
	}

	public APPOINTMENT() {}
	
}
