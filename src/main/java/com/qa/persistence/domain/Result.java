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
	private Long gameId;
	@OneToMany
	private Long winnerId;
	@OneToMany
	private Long loserId;

	public Result() {

	}

	public Result(Long gameId, Long winnerId, Long loserId) {
		super();
		this.gameId = gameId;
		this.winnerId = winnerId;
		this.loserId = loserId;
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

	public Long getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}

	public Long getLoserId() {
		return loserId;
	}

	public void setLoserId(Long loserId) {
		this.loserId = loserId;
	}

}
