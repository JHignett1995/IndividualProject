package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Game {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Long player1Id;
	private Long player2Id;
	private Long winnerID;
	private Long loserID;

	public Game() {
	}

	public Game(Long id, Long player1Id, Long player2Id, Long winnerID, Long loserID) {
		super();
		this.id = id;
		this.player1Id = player1Id;
		this.player2Id = player2Id;
		this.winnerID = winnerID;
		this.loserID = loserID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPlayer1Id() {
		return player1Id;
	}

	public void setPlayer1Id(Long player1Id) {
		this.player1Id = player1Id;
	}

	public Long getPlayer2Id() {
		return player2Id;
	}

	public void setPlayer2Id(Long player2Id) {
		this.player2Id = player2Id;
	}

	public Long getWinnerID() {
		return winnerID;
	}

	public void setWinnerID(Long winnerID) {
		this.winnerID = winnerID;
	}

	public Long getLoserID() {
		return loserID;
	}

	public void setLoserID(Long loserID) {
		this.loserID = loserID;
	}

}
