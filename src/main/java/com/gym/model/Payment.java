package com.gym.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private double cost;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	private String duration;
	
	@ManyToOne
	private SportsMan sportsMan;

	public Payment() {
		super();
	}

	public Payment(double cost, Date date, String duration, SportsMan sportsMan) {
		super();
		this.cost = cost;
		this.date = date;
		this.duration = duration;
		this.sportsMan = sportsMan;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public SportsMan getSportsMan() {
		return sportsMan;
	}

	public void setSportsMan(SportsMan sportsMan) {
		this.sportsMan = sportsMan;
	}
	
	
	
	
}
