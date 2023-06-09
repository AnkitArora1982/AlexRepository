package com.synergy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.synergy.domain.Building;
import com.synergy.service.IBuildingService;

@RestController
public class BuildingController {

	@Autowired
	IBuildingService buildingService;
	
	@RequestMapping(value = "/saveBuilding",method = RequestMethod.POST)
	public Building saveBuilding(@RequestBody Building building) {
		return buildingService.saveBuilding(building);
	}
	
	@RequestMapping(value = "/getBuilding/{roomType}",method = RequestMethod.GET)
	public List<Building> getBuilding(@PathVariable String roomType) {
		return buildingService.getBuildingByRoomType(roomType);
	}
}
