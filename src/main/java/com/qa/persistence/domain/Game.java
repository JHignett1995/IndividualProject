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
@Table(name = "game")
public class Game {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id @OneToMany(mappedBy = "gameId")
	private Long gameId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "participantsId")
	private Participant participantsId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "resutlId")
	private Result resultId;

	public Game() {
	}

	public Long getId() {
		return gameId;
	}

	public void setId(Long id) {
		this.gameId = id;
	}

	public Participant getParticipantsId() {
		return participantsId;
	}

	public void setParticipantsId(Participant participantsId) {
		this.participantsId = participantsId;
	}

	public Result getResultId() {
		return resultId;
	}

	public void setResultId(Result resultId) {
		this.resultId = resultId;
	}
}
