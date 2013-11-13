package com.example.homeworkandroid3.database;



public class Player {
	private final int id;
	private String name, surname;
	private int age, club;
	
	public Player(int id, String name, String surname, int age, int club) {
		this.id = id;
		this.setName(name);
		this.setSurname(surname);
		this.setAge(age);
		this.setClub(club);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getClub() {
		return club;
	}

	public void setClub(int club) {
		this.club = club;
	}

	public int getId() {
		return id;
	}
	
	
}
