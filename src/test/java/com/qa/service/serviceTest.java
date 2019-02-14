package com.qa.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.qa.business.PlayerServiceImpl;
import com.qa.persistence.domain.Player;


public class serviceTest {
	PlayerServiceImpl pServ;

	@Before
	public void setupRepos(){
		pServ = new PlayerServiceImpl();
	}
	@Test
	public void addPlayerTestTotal() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"Password1\"}";
		assertEquals("{\"message\": \"Player has been added\"}",pServ.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestNameContainsNonWordChar() {	
			String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"32515\",\"password\":\"password\"}";
			assertEquals("{\"message\": \"You have entered an invalid character\"}",pServ.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestNameContainsProfanity() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordanpussyfuck\",\"password\":\"password\"}";
		assertEquals("{\"message\": \"You have entered an name containing profanity\"}",pServ.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestPasswordLength() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"psord\"}";
		assertEquals("{\"message\": \"You have entered an incorrect password, password must be 6 chars minimal\"}",pServ.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestPasswordContainsANumber() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"password\"}";
		assertEquals("{\"message\": \"You have entered an incorrect password, password must contain a number\"}",pServ.addPlayer(play1));
	}
	
	@Test
	public void addPlayerTestPasswordContainsACap() {
		String play1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\": \"pa5sword \"}";
		assertEquals("{\"message\": \"You have entered an incorrect password, password must contain a capitial\"}",pServ.addPlayer(play1));
	}
	
	@Test
	public void getAllPlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void getAPlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void removePlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void remove2PlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void updatePlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void update2PlayerTest() {
		fail("TODO");
	}
	
	@Test
	public void addGameTest() {	
		fail("TODO");
	}
	
	@Test
	public void add2GameTest() {
		fail("TODO");
	}
	@Test
	public void getAllGamesTest() {
		fail("TODO");
	}
	
	@Test
	public void getAGameTest() {
		fail("TODO");
	}
	
	@Test
	public void removeGameTest() {
		fail("TODO");
	}
	
	@Test
	public void remove2GameTest() {
		fail("TODO");
	}
	
	@Test
	public void updateGameTest() {
		fail("TODO");
	}
	
	@Test
	public void update2GameTest() {
		fail("TODO");
	}
	
	
}
