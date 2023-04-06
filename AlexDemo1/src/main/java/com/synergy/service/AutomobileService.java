package com.synergy.service;

import java.util.List;

import com.synergy.domain.Automobile;

public interface AutomobileService {

	public Automobile saveAutomobile(Automobile automobile);
	public Automobile getAuto(String autoName);
	public List<Automobile> getAllAuto();
	
}
