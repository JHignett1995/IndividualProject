package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Player{
	
	@Column(name = "Email", nullable = false)
	@Id
	private String email;
	
	private String name;
	private String title;
	private String password;
	private int winCount;
	private int loseCount;
	private int count7BallWall;
	private int rivalID;
	private boolean isAdmin;

	public Player() {
	}

	public Player(String name, String title, String email, String password, int winCount, int loseCount, int count7BallWall,
			int rivalID) {
		this.name = name;
		this.title = title;
		this.email = email;
		this.password = password;
		this.winCount = winCount;
		this.loseCount = loseCount;
		this.count7BallWall = count7BallWall;
		this.rivalID = rivalID;
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

	public int getCount7BallWall() {
		return count7BallWall;
	}

	public void setCount7BallWall(int count7BallWall) {
		this.count7BallWall = count7BallWall;
	}

	public int getRivalID() {
		return rivalID;
	}

	public void setRivalID(int rivalID) {
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
