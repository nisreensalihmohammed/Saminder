package com.home.reminder.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class DIAPER {

	public enum Amount{
		FULL,THIRD, HALF, QUARTER,EMPTY
	}
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private Amount amount; 
	private Date date;
	private Timestamp timestamp;
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public DIAPER( Amount amount, Date date) {
		super();
		this.amount = amount;
		this.date = date;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Amount getAmount() {
		return amount;
	}

	public void setAmount(Amount amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public DIAPER() {}
	@PrePersist
	void preInsert() {
		if (this.timestamp == null) {
			this.timestamp = new Timestamp(System.currentTimeMillis());
		}
	}
}
