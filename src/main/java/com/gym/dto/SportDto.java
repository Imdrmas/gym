package com.gym.dto;

import java.util.List;


public class SportDto {

	private long id;
	
	private String name;
	
	private String description;
	
	private String photo;
	
	private List<ArbitrateDto> arbitrates;

	private List<TrainDto> trains;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public List<ArbitrateDto> getArbitrates() {
		return arbitrates;
	}

	public void setArbitrates(List<ArbitrateDto> arbitrates) {
		this.arbitrates = arbitrates;
	}

	public List<TrainDto> getTrains() {
		return trains;
	}

	public void setTrains(List<TrainDto> trains) {
		this.trains = trains;
	}


}
