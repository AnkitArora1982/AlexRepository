package com.synergy.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergy.domain.Building;
import com.synergy.domain.Room;
import com.synergy.repository.BuildingRepository;
import com.synergy.repository.RoomRepository;

@Service
public class IBuildingService implements BuildingService {

	@Autowired
	BuildingRepository buildingRepository;

	@Autowired
	RoomRepository roomRepository;

	public Building saveBuilding(Building building) {
		Building persistedBuilding = buildingRepository.findByBuName(building.getBuName());
		if (persistedBuilding == null) {
			Set<Room> roomList = building.getRoomList();
			Set<Room> roomPersistList = new HashSet<>();
			for (Room room : roomList) {
				Room persistRoom = roomRepository.save(room);
				roomPersistList.add(persistRoom);
			}
			building.setRoomList(roomPersistList);
			buildingRepository.save(building);
		}
		else {
			
			Set<Room> roomList = building.getRoomList();
			Set<Room> roomPersistList = persistedBuilding.getRoomList();
			for (Room room : roomList) {
				if (roomRepository.findByRoomType(room.getRoomType()) == null) {
					Room persistRoom = roomRepository.save(room);
					roomPersistList.add(persistRoom);
				} else {
					Room persistedRoom = roomRepository.findByRoomType(room.getRoomType());
					persistedRoom.setRoomSize(room.getRoomSize());
					Room savedRoom = roomRepository.save(persistedRoom);
					roomPersistList.add(savedRoom);
					
				}
			}
			building.setRoomList(roomPersistList);
			buildingRepository.save(persistedBuilding);
		}
		return building;

	}

	@Override
	public List<Building> getBuildingByRoomType(String roomType) {
		return buildingRepository.findByRoomList_RoomType(roomType);
	}

}
