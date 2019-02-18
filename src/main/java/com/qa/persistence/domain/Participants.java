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
	private Game gameId;
	@ManyToOne
	private Player player1Id;
	@ManyToOne
	private Player player2Id;

	public Participants() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Game getGameId() {
		return gameId;
	}

	public void setGameId(Game gameId) {
		this.gameId = gameId;
	}

	public Player getPlayer1Id() {
		return player1Id;
	}

	public void setPlayer1Id(Player player1Id) {
		this.player1Id = player1Id;
	}

	public Player getPlayer2Id() {
		return player2Id;
	}

	public void setPlayer2Id(Player player2Id) {
		this.player2Id = player2Id;
	}
}
