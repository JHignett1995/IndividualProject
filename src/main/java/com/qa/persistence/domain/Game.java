package com.qa.persistence.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@ManyToOne
	private Participants participantsId;
	@OneToMany
	private Result resultId;

	public Game() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Participants getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(Participants participantsId) {
		this.participantsId = participantsId;
	}

	public Result getResultId() {
		return resultId;
	}

	public void setResultId(Result resultId) {
		this.resultId = resultId;
	}
}
