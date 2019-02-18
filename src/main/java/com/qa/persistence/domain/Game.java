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
	private Long participantsId;
	private Long resultId;

	public Game() {
	}

	public Game(Long id, Long participantsId, Long resultId) {
		super();
		this.id = id;
		this.participantsId = participantsId;
		this.resultId = resultId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(Long participantsId) {
		this.participantsId = participantsId;
	}

	public Long getResultId() {
		return resultId;
	}

	public void setResultId(Long resultId) {
		this.resultId = resultId;
	}
}
