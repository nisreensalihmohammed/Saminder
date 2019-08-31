package com.home.reminder.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.home.reminder.entities.DIAPER;


@Repository
public interface diaperRepository extends CrudRepository<DIAPER, Integer>{

}
