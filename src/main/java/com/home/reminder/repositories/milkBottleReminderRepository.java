package com.home.reminder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.reminder.entities.MILK_BOTTLE_REMINDER;

@Repository
public interface milkBottleReminderRepository extends CrudRepository<MILK_BOTTLE_REMINDER, Integer> {

}
