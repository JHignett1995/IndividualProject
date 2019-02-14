package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.GameService;


@Path("/game")
public class GameEndpoint {
	@Inject
	private GameService service;
	
	@Path("/getAllGames")
	@GET
	@Produces({"application/json"})
	public String getAllRecipes() {
		return service.getAllGames();
	}
	
	@Path("/getAGame/{id}")
	@GET
	@Produces({"application/json"})
	public String getAGame(@PathParam("id") Long id) {
		return service.getAGame(id);
	}
	
	@Path("/createGame")
	@POST
	@Produces({"application/json"})
	public String addGame(String game) {
		return service.addGame(game);
	}
	
	@Path("/deleteGame/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteGame(@PathParam("id") Long id) {
		return service.deleteGame(id);
	}
	
	@Path("/updateGame/{game}/{id}")
	@POST
	@Produces({"application/json"})
	public String editGame(@PathParam("game" + "id")String game ,Long id) {
		return service.updateGame(game, id);
		
	}
}
