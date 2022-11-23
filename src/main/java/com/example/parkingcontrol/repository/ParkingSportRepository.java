package com.example.parkingcontrol.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingcontrol.model.ParkingSportModel;

@Repository
public interface ParkingSportRepository extends JpaRepository<ParkingSportModel, UUID>{

}
