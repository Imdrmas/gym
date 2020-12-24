package com.gym.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private String description;
	
	private String photo;

	@ManyToOne
	private SportsMan sportsMan;
	
	@ManyToOne
	private Gym gym;
	
	@OneToMany(mappedBy = "sport")
	private List<Arbitrate> arbitrates;
	
	@OneToMany(mappedBy = "sport")
	private List<Train> trains;

	public Sport() {
		super();
	}

	public Sport(String name, String description, String photo, SportsMan sportsMan, List<Arbitrate> arbitrates,
			List<Train> trains, Gym gym) {
		super();
		this.name = name;
		this.description = description;
		this.photo = photo;
		this.sportsMan = sportsMan;
		this.arbitrates = arbitrates;
		this.trains = trains;
		this.gym = gym;
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

	public SportsMan getSportsMan() {
		return sportsMan;
	}

	public void setSportsMan(SportsMan sportsMan) {
		this.sportsMan = sportsMan;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
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

	public void addArbitrate(Arbitrate arbitrate) {
		if (getArbitrates()==null) {
			this.arbitrates = new ArrayList<>();
		}
		getArbitrates().add(arbitrate);
		arbitrate.setSport(this);
	}
	
	public void addTrain(Train train) {
		if (getTrains()==null) {
			this.trains = new ArrayList<>();
		}
		getTrains().add(train);
		train.setSport(this);
	}
	
}
