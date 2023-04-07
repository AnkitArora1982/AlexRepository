package com.synergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.synergy.domain.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{

	public Room findByRoomType(String roomType);
	
}
