package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Game")
public class Game {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long gameId;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "playerId")
	private Player playerId;
	private Long referenceNumber = 0L;
	private String resultStatus;
	private int refCount =0;
	


	public Game() {
	}

	public Game(Player playerId) {
		super();
		this.playerId = playerId;
		refCount++;
		if (refCount == 2) {
			referenceNumber++;
			refCount = 0;
		}
		setReferenceNumber(referenceNumber);
	}

	public Long getGameId() {
		return gameId;
	}

	public void setGameId(Long gameId) {
		this.gameId = gameId;
	}

	public Player getPlayerId() {
		return playerId;
	}

	public void setPlayerId(Player playerId) {
		this.playerId = playerId;
	}

	public String getResultStatus() {
		return resultStatus;
	}

	public void setResultStatus(String resultStatus) {
		this.resultStatus = resultStatus;
	}

	public Long getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(Long referenceNumber) {
		this.referenceNumber = referenceNumber;
	}
	
}
