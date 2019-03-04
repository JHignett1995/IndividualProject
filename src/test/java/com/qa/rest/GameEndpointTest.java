package com.qa.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.GameService;

@RunWith(MockitoJUnitRunner.class)
public class GameEndpointTest {
	@InjectMocks
	private GameEndpoint endpoint;

	@Mock
	private GameService service;
	
	private static final String MockObject1 = "{\"email\": \"1@gmail.com\",\"name\":\"Jordan\",\"password\":\"Password1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"2@gmail.com\",\"isAdmin\":\"true\"}";
	private static final String mockObject2 = "{\"email\": \"2@gmail.com\",\"name\":\"Jrdan\",\"password\":\"Pasword1\",\"winCount\":0,\"loseCount\":0,\"count7Ball\":0,\"rivalID\":\"1@gmail.com\",\"isAdmin\":\"true\"}";


	private static final String MOCK_VALUE = "test_value";

	@Before
	public void setup() {
		endpoint.setService(service);
	}

	@Test
	public void getAllTest() {
		Mockito.when(service.getAllGames()).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE,endpoint.getAllGames());
	}
	
	@Test
	public void getATest() {
		Mockito.when(service.getAGame(1L)).thenReturn(MockObject1);
		assertEquals(MockObject1, endpoint.getAGame(1L));
	}
	
	@Test
	public void updateTest() {
		Mockito.when(service.updateGame(MockObject1, mockObject2, 1L)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.editGame(MockObject1, mockObject2, 1L));
		Mockito.verify(service).updateGame(MockObject1, mockObject2, 1L);
	}
	
	@Test
	public void deleteTest() {
		Mockito.when(service.deleteGame(1L)).thenReturn(mockObject2);
		assertEquals(mockObject2, endpoint.deleteGame(1L));
		Mockito.verify(service).deleteGame(1L);
	}
	
	@Test
	public void createTest() {
		Mockito.when(service.addGame(MockObject1, mockObject2)).thenReturn(MOCK_VALUE);
		assertEquals(MOCK_VALUE, endpoint.addGame(MockObject1, mockObject2));
		Mockito.verify(service).addGame(MockObject1, mockObject2);
	}
	
}
