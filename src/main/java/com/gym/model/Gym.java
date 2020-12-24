package com.gym.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Gym {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;

	private String address;

	private String city;

	private int area;
	
	private String logo;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
	private List<Worktime> worktimes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
	private List<Sport> sports;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
	private List<Arbitrate> arbitrates;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "gym")
	private List<Train> trains;

	public Gym() {
		super();
	}

	public Gym(String name, String address, String city, int area, String logo, List<Worktime> worktimes,
			List<Sport> sports, List<Arbitrate> arbitrates, List<Train> trains) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.area = area;
		this.logo = logo;
		this.worktimes = worktimes;
		this.sports = sports;
		this.arbitrates = arbitrates;
		this.trains = trains;
	}

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

	public List<Worktime> getWorktimes() {
		return worktimes;
	}

	public void setWorktimes(List<Worktime> worktimes) {
		this.worktimes = worktimes;
	}

	public List<Sport> getSports() {
		return sports;
	}

	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}
	
	public List<Arbitrate> getArbitrates() {
		return arbitrates;
	}

	public void setArbitrates(List<Arbitrate> arbitrates) {
		this.arbitrates = arbitrates;
	}

	public List<Train> getTrains() {
		return trains;
	}

	public void setTrains(List<Train> trains) {
		this.trains = trains;
	}

	public void addWorktime(Worktime worktime) {
		if (getWorktimes()==null) {
			this.worktimes = new ArrayList<>();
		}
		getWorktimes().add(worktime);
	    worktime.setGym(this);	
	}
	
	public void addSportForGym(Sport sport) {
		if(getSports()==null) {
			this.sports = new ArrayList<>();
		}
		getSports().add(sport);
		sport.setGym(this);	
	}
	
	public void addArbitrate(Arbitrate arbitrate) {
		if (getArbitrates()==null) {
			this.arbitrates = new ArrayList<>();
		}
		getArbitrates().add(arbitrate);
		arbitrate.setGym(this);
	} 
	
	public void addTrain(Train train) {
		if (getTrains()==null) {
			this.trains = new ArrayList<>();
		}
		getTrains().add(train);
		train.setGym(this);
	}
}
