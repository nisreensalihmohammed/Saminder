package com.home.reminder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.reminder.entities.APPOINTMENT_REMINDER;
@Repository
public interface appointmentReminderRepository extends CrudRepository<APPOINTMENT_REMINDER, Integer> {

	

}
