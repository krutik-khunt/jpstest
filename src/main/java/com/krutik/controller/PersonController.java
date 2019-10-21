package com.krutik.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.krutik.model.Person;
import com.krutik.model.PersonDetails;
import com.krutik.service.PersonDetailsService;
import com.krutik.service.PersonService;

@Controller
@RequestMapping("person")
public class PersonController {

	@Autowired
	PersonService personobj;
	
	@Autowired
	PersonDetailsService pdservice;

	@Autowired
	PersonDetailsService pdobj;

	@RequestMapping("/")
	public ModelAndView viewPerson() {
		ModelAndView mv = new ModelAndView("viewPerson");
		mv.addObject("list", pdservice.findAll());
		return mv;
	}

	@RequestMapping("/edit/{id}")
	public ModelAndView editPerson(@PathVariable(name = "id") int id) {
		ModelAndView mv = new ModelAndView("addperson");
		Optional<Person> popt = personobj.findById(id);
		if (popt.isPresent()) {
			Person per = popt.get();
			if (per != null) {
				mv.addObject("data", per);
				System.out.println("per---> "+per);
				mv.addObject("details", per.getPd());
			}
		} else {
			mv.setViewName("redirect:/person/");
		}
		return mv;
	}

	@RequestMapping("/add")
	public String getPerson() {
		return "addperson";
	}

	@RequestMapping("/save")
	public String savePerson(@ModelAttribute Person p,
			@RequestParam(value = "detailid") int[] editid,
			@RequestParam(value = "city") String[] city,
			@RequestParam(value = "address") String[] address,
			@RequestParam(value = "pincode") String[] pincode) {
		List<PersonDetails> pdlist = null;
		if (city != null && city.length > 0) {
			pdlist = new ArrayList<PersonDetails>();
			PersonDetails pd;
			for (int i = 0; i < city.length; i++) {
				pd = new PersonDetails(city[i], address[i], pincode[i], p);
				if (editid[i] != 0) {
					pd.setId(editid[i]);
				}
				pdlist.add(pd);
			}
		}
		p.setPd(pdlist);
		personobj.save(p);

		return "redirect:/person/";
	}
}
