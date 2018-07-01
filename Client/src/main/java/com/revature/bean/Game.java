package com.revature.bean;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Game {
	int id;
	
	String title;
	
	String genre;
	
	int releaseYear;
	
	public Game() {
		super();
	}

	public Game(int id, String title, String genre, int releaseYear) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.releaseYear = releaseYear;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		return "Game [id=" + id + ", title=" + title + ", genre=" + genre + ", releaseYear=" + releaseYear + "]";
	}
}