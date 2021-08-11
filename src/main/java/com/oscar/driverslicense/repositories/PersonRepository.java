package com.oscar.driverslicense.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.oscar.driverslicense.models.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findAll();
}
