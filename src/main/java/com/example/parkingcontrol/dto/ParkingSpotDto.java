package com.example.parkingcontrol.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {
	@NotBlank
	private String parkingSportNumber; //número de estacionamento
	@NotBlank
	@Size(max = 7)
	private String licensePlateCar; //placa de carro
	@NotBlank
	private String brandCar; //marca do carro
	@NotBlank
	private String modelCar; //modelo do carro
	@NotBlank
	private String colorCar; //cor Do Carro
	
	@NotBlank
	private String responsableName; //nome do responsável
	@NotBlank
	private String apartament; //apartamento
	@NotBlank
	private String block; //bloco
	
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

	
	
}
