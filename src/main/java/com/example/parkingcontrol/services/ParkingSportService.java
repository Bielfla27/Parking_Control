package com.example.parkingcontrol.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingcontrol.repository.ParkingSportRepository;

@Service
public class ParkingSportService {
	
	
	final ParkingSportRepository parkingSportRepository;
	
	public ParkingSportService(ParkingSportRepository parkingSportRepository) {
		this.parkingSportRepository = parkingSportRepository;
		
	}

}
