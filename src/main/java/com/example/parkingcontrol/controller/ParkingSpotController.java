package com.example.parkingcontrol.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.swing.text.html.Option;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
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
	

	@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
	@GetMapping
	public ResponseEntity<List<ParkingSpotModel>> getAllParkingSports(){
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findyAll());
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_USER')")
	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id") UUID id){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findyById(id);
		if(!parkingSpotModelOptional.isPresent()) { //verifica se tem dados com o id
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não existe");
		}
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findyById(id);
		if(!parkingSpotModelOptional.isPresent()) { //verifica se tem dados com o id
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não existe");
		}
		parkingSpotService.delete(parkingSpotModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Vaga deletada com sucesso");
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id") UUID id,
													@RequestBody @Valid ParkingSpotDto parkingSpotDto){
		Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findyById(id);
		if(!parkingSpotModelOptional.isPresent()) { //verifica se tem dados com o id
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Vaga não existe");
		}
		var parkingSpotModel = new ParkingSpotModel(); 
		BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel); //estou convertendo o DTO em parkingSpotModel   
		parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
		parkingSpotModel.setRegistrationDate(parkingSpotModelOptional.get().getRegistrationDate());
		return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.save(parkingSpotModel));
	}
}
