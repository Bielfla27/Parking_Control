package com.example.parkingcontrol.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TAB_PARKING_SPORT")
public class ParkingSportModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false, unique = true, length = 10) 
	private String parkingSportNumber; //número de estacionamento
	@Column(nullable = false, unique = true, length = 7) 
	private String licensePlateCar; //placa de carro
	@Column(nullable = false,  length = 70) 
	private String brandCar; //marca do carro
	@Column(nullable = false, length = 70) 
	private String modelCar; //modelo do carro
	@Column(nullable = false, length = 70) 
	private String colorCar; //cor Do Carro
	@Column(nullable = false) 
	private LocalDateTime registrationDate; //data de registro
	@Column(nullable = false, length = 130) 
	private String responsableName; //nome do responsável
	@Column(nullable = false, length = 30) 
	private String apartament; //apartamento
	@Column(nullable = false, length = 30) 
	private String block; //bloco
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getParkingSportNumber() {
		return parkingSportNumber;
	}
	public void setParkingSportNumber(String parkingSportNumber) {
		this.parkingSportNumber = parkingSportNumber;
	}
	public String getLicensePlateCar() {
		return licensePlateCar;
	}
	public void setLicensePlateCar(String licensePlateCar) {
		this.licensePlateCar = licensePlateCar;
	}
	public String getBrandCar() {
		return brandCar;
	}
	public void setBrandCar(String brandCar) {
		this.brandCar = brandCar;
	}
	public String getModelCar() {
		return modelCar;
	}
	public void setModelCar(String modelCar) {
		this.modelCar = modelCar;
	}
	public String getColorCar() {
		return colorCar;
	}
	public void setColorCar(String colorCar) {
		this.colorCar = colorCar;
	}
	public LocalDateTime getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(LocalDateTime registrationDate) {
		this.registrationDate = registrationDate;
	}
	public String getResponsableName() {
		return responsableName;
	}
	public void setResponsableName(String responsableName) {
		this.responsableName = responsableName;
	}
	public String getApartament() {
		return apartament;
	}
	public void setApartament(String apartament) {
		this.apartament = apartament;
	}
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
