package com.gym.model;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Worktime {
  
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String day;
	
	@Temporal(TemporalType.DATE)
	private Date timetable;
	
	private String start;
	
	private String end;
	
	@ManyToOne
	private Gym gym;
	
	@OneToMany(mappedBy = "Worktime")
	private List<SportsMan> sportsMans;
	
	public Worktime() {
		super();
	}

	public Worktime(String day, Date timetable, String start, String end, Gym gym, List<SportsMan> sportsMans) {
		super();
		this.day = day;
		this.timetable = timetable;
		this.start = start;
		this.end = end;
		this.gym = gym;
		this.sportsMans = sportsMans;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getTimetable() {
		return timetable;
	}

	public void setTimetable(Date timetable) {
		this.timetable = timetable;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public Gym getGym() {
		return gym;
	}

	public void setGym(Gym gym) {
		this.gym = gym;
	}

	public List<SportsMan> getSportsMans() {
		return sportsMans;
	}

	public void setSportsMans(List<SportsMan> sportsMans) {
		this.sportsMans = sportsMans;
	}

	public void addSportsManForWork(SportsMan sportsMan) {
		if (getSportsMans()==null) {
			this.sportsMans = new ArrayList<>();
		}
		getSportsMans().add(sportsMan);
		sportsMan.setWorktime(this);
	}
	
}
