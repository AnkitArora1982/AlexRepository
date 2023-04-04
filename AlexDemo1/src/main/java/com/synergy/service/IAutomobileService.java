package com.synergy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.Automobile;
import com.synergy.repository.AutomobileRepository;

@Service
public class IAutomobileService implements AutomobileService{

	@Autowired
	AutomobileRepository automobileRepository;
	
	@Override
	public Automobile saveAutomobile(Automobile automobile) {
		return automobileRepository.save(automobile);
		
	}

}
