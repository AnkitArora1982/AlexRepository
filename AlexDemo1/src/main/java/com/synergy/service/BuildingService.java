package com.synergy.service;

import java.util.List;

import com.synergy.domain.Building;

public interface BuildingService {

	public Building saveBuilding(Building building);
	
	public List<Building> getBuildingByRoomType(String roomType);
	
}
