package com.oscar.driverslicense.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.oscar.driverslicense.models.License;
import com.oscar.driverslicense.models.Person;
import com.oscar.driverslicense.services.LicenseService;
import com.oscar.driverslicense.services.PersonService;

@Controller
public class MainController {
	private final LicenseService licnService;
	private final PersonService persService;
	
	public MainController(LicenseService licnService, PersonService persService) {
		this.licnService = licnService;
		this.persService = persService;
	}
	
	@RequestMapping("/persons/new")
	public String newPerson(@ModelAttribute("person") Person person, BindingResult result) {
		return "newPerson.jsp";
	}
	
	@RequestMapping(value="/persons/create", method=RequestMethod.POST)
	public String createPerson(@ModelAttribute("person") Person person, BindingResult result) {
		persService.createPerson(person);
		return "redirect:/licenses/new";
	}
	
	@RequestMapping("/persons/{id}")
	public String showPerson(@PathVariable("id") String id, Model model) {
		model.addAttribute("person", persService.findPerson(Long.parseLong(id)));
		model.addAttribute("license", licnService.getLicenseByPersonId(Long.parseLong(id)));
		return "showPerson.jsp";
	}
	
	@RequestMapping("/licenses/new")
	public String newLicense(Model model) {
		model.addAttribute("people", persService.getAll());
		return "newLicense.jsp";
	}
	
	@RequestMapping(value="/licenses/create", method=RequestMethod.POST)
	public String createLicense(@RequestParam("person") String person, @RequestParam("state") String state,
				@RequestParam("date") String date
			) {
		Person pers = persService.findPerson(Long.parseLong(person));
		Date parsed = null;
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			parsed = df.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
//		DateFormat dft = new SimpleDateFormat("MM/dd/yyyy");
//		String dfts = dft.format(parsed);
//		System.out.println(date);
//		System.out.println(parsed);
//		System.out.println(dfts);
		License license = new License(parsed, state, pers);
		licnService.createLicense(license);
		
		return "redirect:/persons/" + pers.getId();
	}
}
