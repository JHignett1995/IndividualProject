package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "participants")
public class Participants {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@OneToMany
	private Long id;
	@ManyToOne
	private Long gameId;
	@ManyToOne
	private Long player1Id;
	@ManyToOne
	private Long player2Id;

	public Participants() {
		super();
	}

	public Participants(Long gameId, Long player1Id, Long player2Id) {
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
