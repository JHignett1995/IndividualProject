package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "Player")
public class Player {
	@Id
	@Column(name = "email",unique=true,columnDefinition="VARCHAR(255)")
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name = "fk_game")
	
	private List<Game> games;
	
	
	private String name;
	private String title;
	private String password;
	private int winCount;
	private int loseCount;
	private int count7Ball;
	private String rivalID;
	private boolean isAdmin;

	public Player() {
	}

	public Player(String email, String name, String password) {
		this.name = name;
		this.title = "";
		this.email = email;
		this.password = password;
		this.winCount = 0;
		this.loseCount = 0;
		this.count7Ball = 0;
		this.rivalID = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getWinCount() {
		return winCount;
	}

	public void setWinCount(int winCount) {
		this.winCount = winCount;
	}

	public int getLoseCount() {
		return loseCount;
	}

	public void setLoseCount(int loseCount) {
		this.loseCount = loseCount;
	}

	public int getCount7Ball() {
		return count7Ball;
	}

	public void setCount7Ball(int count7Ball) {
		this.count7Ball = count7Ball;
	}

	public String getRivalID() {
		return rivalID;
	}

	public void setRivalID(String rivalID) {
		this.rivalID = rivalID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
