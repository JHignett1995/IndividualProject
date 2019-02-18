package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participants {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	private Long gameId;
	private Long player1Id;
	private Long player2Id;

	public Participants() {
		super();
	}

	public Participants(Long id, Long gameId, Long player1Id, Long player2Id) {
		super();
		this.id = id;
		this.gameId = gameId;
		this.player1Id = player1Id;
		this.player2Id = player2Id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
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
}
