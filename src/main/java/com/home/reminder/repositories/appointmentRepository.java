package com.home.reminder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.reminder.entities.APPOINTMENT;

@Repository
public interface appointmentRepository extends CrudRepository<APPOINTMENT, Integer>{

}
