package com.example.homeworkandroid3.database;

import android.R.integer;

public class Club {
	private final int id;
	private String name, city, league;
	private int yearOfFoundation;
	
	
	public Club(int id, String name, String city, String league, int yearOfFound) {
		this.id = id;
		this.name = name;
		this.city = city;
		this.league = league;
		this.yearOfFoundation = yearOfFound;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public int getYearOfFoundation() {
		return yearOfFoundation;
	}

	public void setYearOfFoundation(int yearOfFoundation) {
		this.yearOfFoundation = yearOfFoundation;
	}
}
