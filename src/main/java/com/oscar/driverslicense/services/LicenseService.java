package com.oscar.driverslicense.services;

import org.springframework.stereotype.Service;

import com.oscar.driverslicense.models.License;
import com.oscar.driverslicense.repositories.LicenseRepository;

@Service
public class LicenseService {
	private final LicenseRepository licnRepo;
	
	public LicenseService(LicenseRepository licnRepo) {
		this.licnRepo = licnRepo;
	}
	
	public License createLicense(License license) {
		return licnRepo.save(license);
	}
	
	public License getLicenseByPersonId(Long id) {
		return licnRepo.findByPersonId(id);
	}
}
