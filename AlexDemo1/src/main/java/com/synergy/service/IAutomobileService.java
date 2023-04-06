package com.synergy.service;

import java.util.List;

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

	@Override
	public Automobile getAuto(String autoName) {
		// TODO Auto-generated method stub
		return automobileRepository.findByName(autoName);
	}

	@Override
	public List<Automobile> getAllAuto() {
		return automobileRepository.findAll();
	}

}
