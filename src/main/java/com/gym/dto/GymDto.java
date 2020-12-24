package com.gym.dto;

import java.util.List;

public class GymDto {

	private long id;

	private String name;

	private String address;

	private String city;

	private int area;
	
	private String logo;

	private List<WorktimeDto> worktimes;
	
	private List<SportDto> sports;
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public List<WorktimeDto> getWorktimes() {
		return worktimes;
	}

	public void setWorktimes(List<WorktimeDto> worktimes) {
		this.worktimes = worktimes;
	}

	public List<SportDto> getSports() {
		return sports;
	}

	public void setSports(List<SportDto> sports) {
		this.sports = sports;
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
