package com.gym.dto;

import java.util.Date;
import java.util.List;


public class WorktimeDto {
  
	private long id;
	
	private String day;
	
	private Date timetable;
	
	private String start;
	
	private String end;

	private List<SportsManDto> sportsMans;
	
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

	public List<SportsManDto> getSportsMans() {
		return sportsMans;
	}

	public void setSportsMans(List<SportsManDto> sportsMans) {
		this.sportsMans = sportsMans;
	}

}
