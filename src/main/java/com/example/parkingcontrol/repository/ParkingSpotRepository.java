package com.example.parkingcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingcontrol.model.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{

	boolean existsBylicensePlateCar(String licensePlateCar);
	boolean existsByParkingSportNumber(String parkingSportNumber);
	boolean existsByApartamentAndBlock(String apartament, String block);
}
