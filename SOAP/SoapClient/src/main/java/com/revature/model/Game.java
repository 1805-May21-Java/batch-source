package com.revature.model;

public class Game {
	int id;
	String name;	
	String genre;	
	int releaseYear;
	
	public Game() {
		super();
	}

	public Game(int id, String name, String genre, int releaseYear) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", genre=" + genre + ", releaseYear=" + releaseYear + "]";
	}
}
