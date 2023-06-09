package com.synergy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.synergy.domain.Automobile;
import com.synergy.service.IAutomobileService;

@RestController
public class AutomobileController {

	@Autowired
	IAutomobileService automobileService;
	
	@RequestMapping(value = "/saveAutomobile",method = RequestMethod.POST)
	public Automobile saveAutomobile(@RequestBody Automobile automobile) {
		return automobileService.saveAutomobile(automobile);
	}
	
	@RequestMapping(value = "/getAuto/{autoName}",method = RequestMethod.GET)
	public Automobile getAuto(@PathVariable String autoName) {
		return automobileService.getAuto(autoName);
	}
	
	@RequestMapping(value = "/getAllAuto",method = RequestMethod.GET)
	public List<Automobile> getAllAuto() {
		return automobileService.getAllAuto();
	}
	
}
