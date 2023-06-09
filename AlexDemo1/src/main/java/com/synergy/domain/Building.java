package com.synergy.domain;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Building {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int buId;
	private String buName;
	
	@OneToMany
	private Set<Room> roomList;

	public int getBuId() {
		return buId;
	}

	public void setBuId(int buId) {
		this.buId = buId;
	}

	public String getBuName() {
		return buName;
	}

	public void setBuName(String buName) {
		this.buName = buName;
	}

	public Set<Room> getRoomList() {
		return roomList;
	}

	public void setRoomList(Set<Room> roomList) {
		this.roomList = roomList;
	}
	
	
}
