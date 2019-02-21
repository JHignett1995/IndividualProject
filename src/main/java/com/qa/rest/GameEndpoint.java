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
	
	@Path("/getAGame/{refNum}")
	@GET
	@Produces({"application/json"})
	public String getAGame(@PathParam("refNum") Long refNum) {
		return service.getAGame(refNum);
	}
	
	@Path("/createGame")
	@POST
	@Produces({"application/json"})
	public String addGame(String gameP1, String GameP2) {
		return service.addGame(gameP1, GameP2);
	}
	
	@Path("/deleteGame/{refNum}")
	@DELETE
	@Produces({"application/json"})
	public String deleteGame(@PathParam("refNum") Long refNum) {
		return service.deleteGame(refNum);
	}
	
	@Path("/updateGame/{gameP1}/{gameP2}/{refNum}")
	@POST
	@Produces({"application/json"})
	public String editGame(@PathParam("gameP1")String gameP1,@PathParam("gameP2") String gameP2 ,@PathParam("refNum")Long refNum) {
		return service.updateGame(gameP1, gameP2, refNum);
	}
}
