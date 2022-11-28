package com.example.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingcontrol.dto.ParkingSpotDto;
import com.example.parkingcontrol.model.ParkingSpotModel;
import com.example.parkingcontrol.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600) //permitir que seja acessada de qualquer fonte
@RequestMapping("/parking-spot")
public class ParkingSpotController {
	
	final ParkingSpotService parkingSpotService;
	
	public ParkingSpotController(ParkingSpotService parkingSpotService) {
		this.parkingSpotService = parkingSpotService;
	}
	
	@PostMapping
	public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){ //salvaEstacionamento
		if(parkingSpotService.existsBylicensePlateCar(parkingSpotDto.getLicensePlateCar())) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Já existe um carro cadastrada com essa placa");
		}
		if(parkingSpotService.existsByParkingSportNumber(parkingSpotDto.getParkingSportNumber())) {
			return ResponseEntity.status(HttpStatus.CREATED).body("Essa vaga de estacionamento já está ocupada com um carro");
		}
		if(parkingSpotService.existsByApartamentAndBlock(parkingSpotDto.getApartament(), parkingSpotDto.getBlock())) {
			return ResponseEntity.status(HttpStatus.CREATED).body("A pessoa cadastrada com esse apartamento já possui uma vaga cadastrada");
		}
		
		var parkingSpotModel = new ParkingSpotModel(); //variavel var séria a mesma coisa de iniciar como se fosse uma classe
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); //estou convertendo o DTO em parkingSpotModel   
		parkingSpotModel.setRegistrationDate(LocalDateTime.now(ZoneId.of("UTC"))); //salvando a data da hora de registro
		return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
		
	}

}
