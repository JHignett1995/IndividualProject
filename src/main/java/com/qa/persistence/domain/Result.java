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

@Table(name="result")
@Entity
public class Result {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @OneToMany(mappedBy = "resultId")
	private Long resultId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gameID")
	private Game gameId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "winnerId")
	private Player winnerId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "loserId")
	private Player loserId;

	public Result() {

	}

	public Long getId() {
		return resultId;
	}

	public void setId(Long id) {
		this.resultId = id;
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
