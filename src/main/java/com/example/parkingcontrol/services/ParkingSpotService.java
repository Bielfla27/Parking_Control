package com.example.parkingcontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingcontrol.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	
	final ParkingSpotRepository parkingSportRepository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSportRepository) {
		this.parkingSportRepository = parkingSportRepository;
		
	}

}
