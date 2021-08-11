package com.oscar.driverslicense.repositories;

import org.springframework.data.repository.CrudRepository;

import com.oscar.driverslicense.models.License;

public interface LicenseRepository extends CrudRepository<License, Long> {
	License findByPersonId(Long id);
}
