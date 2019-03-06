package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.PlayerService;

@RunWith(MockitoJUnitRunner.class)
public class PlayerEndpointTest {
	@InjectMocks
	private PlayerEndpoint endpoint;

	@Mock
	private PlayerService service;
	
	private static final String MockObject1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@gmail.com\",\"isAdmin\":\"true\"}";
	private static final String mockObject2 = "{\"email\": \"2@gmail.com\",\"name\":\"Jrdan\",\"password\":\"Pasword1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"1@gmail.com\",\"isAdmin\":\"true\"}";


	private static final String MOCK_VALUE = "test_value";

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void getAllTest() {
		Mockito.when(service.getAllPlayers()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE,endpoint.getAllPlayers());
	}
	
	@Test
	public void getATest() {
		Mockito.when(service.getAPlayerEmail("1@gmail.com")).thenReturn(MockObject1);
		assertEquals(MockObject1, endpoint.getAPlayer("1@gmail.com"));
	}
	
	@Test
	public void updateTest() {
		Mockito.when(service.updatePlayer(MOCK_VALUE, "1@gmail.com")).thenReturn(mockObject2);
		assertEquals(mockObject2, endpoint.editPlayer(MOCK_VALUE, "1@gmail.com"));
		Mockito.verify(service).updatePlayer(MOCK_VALUE, "1@gmail.com");
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(service.deletePlayer("1@gmail.com")).thenReturn(mockObject2);
		assertEquals(mockObject2, endpoint.deletePlayer("1@gmail.com"));
		Mockito.verify(service).deletePlayer("1@gmail.com");
	}
	
	@Test
	public void createTest() {
		Mockito.when(service.addPlayer(MOCK_VALUE)).thenReturn(mockObject2);
		assertEquals(mockObject2, endpoint.addPlayer(MOCK_VALUE));
		Mockito.verify(service).addPlayer(MOCK_VALUE);
	}
	
}
