package com.example.parkingcontrol.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

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
	
	public boolean existsBylicensePlateCar(String licensePlateCar) {
		return parkingSportRepository.existsBylicensePlateCar(licensePlateCar);
	}

	public boolean existsByParkingSportNumber(String parkingSportNumber) {
		return parkingSportRepository.existsByParkingSportNumber(parkingSportNumber);
	}
	
	public boolean existsByApartamentAndBlock(String apartament, String block) {
		return parkingSportRepository.existsByApartamentAndBlock(apartament, block);
	}

	public List<ParkingSpotModel> findyAll() {
		// TODO Auto-generated method stub
		return parkingSportRepository.findAll();
	}

	public Optional<ParkingSpotModel> findyById(UUID id) {
		// TODO Auto-generated method stub
		return parkingSportRepository.findById(id);
	}

	@Transactional
	public void delete(ParkingSpotModel parkingSpotModel) {
		// TODO Auto-generated method stub
		parkingSportRepository.delete(parkingSpotModel);
	}
	
	
}
