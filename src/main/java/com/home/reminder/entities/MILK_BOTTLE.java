package com.home.reminder.entities;



import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;



@Entity
public class MILK_BOTTLE {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Integer id;
	private Integer size;
	private Date filling_time;
	private Date finish_time;
	private Timestamp timestamp;
	
	@PrePersist
	void preInsert() {
		if (this.timestamp == null) {
			this.timestamp = new Timestamp(System.currentTimeMillis());
		}
	}
	
	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public MILK_BOTTLE(Integer size, Date filling_time, Date finish_time) {
		super();
		this.size = size;
		this.filling_time = filling_time;
		this.finish_time = finish_time;
		this.timestamp = new Timestamp(System.currentTimeMillis());
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;                           
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Date getFilling_time() {
		return filling_time;
	}

	public void setFilling_time(Date filling_time) {
		this.filling_time = filling_time;
	}

	public Date getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(Date finish_time) {
		this.finish_time = finish_time;
	}
	public MILK_BOTTLE() {}
}
