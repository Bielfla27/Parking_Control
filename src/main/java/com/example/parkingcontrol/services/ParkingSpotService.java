package com.example.parkingcontrol.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.parkingcontrol.model.ParkingSpotModel;
import com.example.parkingcontrol.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {
	
	
	final ParkingSpotRepository parkingSportRepository;
	
	public ParkingSpotService(ParkingSpotRepository parkingSportRepository) {
		this.parkingSportRepository = parkingSportRepository;
		
	}

	@Transactional
	public Object save(ParkingSpotModel parkingSpotModel) {
		return parkingSportRepository.save(parkingSpotModel);
	}

}
