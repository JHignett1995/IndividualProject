package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "participant")
public class Participant {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@OneToMany(mappedBy = "participantId")
	private Long participantId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gameId")
	private Game gameId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player1Id")
	private Player player1Id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "player2Id")
	private Player player2Id;

	public Participant() {
		super();
	}

	public Long getId() {
		return participantId;
	}

	public void setId(Long id) {
		this.participantId = id;
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
