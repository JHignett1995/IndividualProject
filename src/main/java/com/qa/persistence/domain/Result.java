package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="result")
@Entity
public class Result {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @OneToMany
	private Long id;
	@ManyToOne
	private Game gameId;
	@OneToMany
	private Player winnerId;
	@OneToMany
	private Player loserId;

	public Result() {

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

	public Player getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Player winnerId) {
		this.winnerId = winnerId;
	}

	public Player getLoserId() {
		return loserId;
	}

	public void setLoserId(Player loserId) {
		this.loserId = loserId;
	}

}
