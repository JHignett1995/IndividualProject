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
	@Produces({ "application/json" })
	public String getAllGames() {
		return service.getAllGames();
	}

	@Path("/getAGame/{refNum}")
	@GET
	@Produces({ "application/json" })
	public String getAGame(@PathParam("refNum") Long refNum) {
		return service.getAGame(refNum);
	}
	@Path("/getAGamebyPlayer/{email}")
	@GET
	@Produces({ "application/json" })
	public String getAGamebyPlayer(@PathParam("email") String email) {
		return service.getAGamebyPlayer(email);
	}

	@Path("/createGame/{player1}/{player2}")
	@POST
	@Produces({ "application/json" })
	public String addGame(@PathParam("player1")String player1,@PathParam("player2")String player2) {
		System.out.println("endpoint: " + player1 + "  " + player2);
		return service.addGame(player1, player2);
	}

	@Path("/deleteGame/{refNum}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteGame(@PathParam("refNum") Long refNum) {
		return service.deleteGame(refNum);
	}

	@Path("/updateGame/{winnerEmail}/{loserEmail}/{refNum}/{count7Ball}")
	@POST
	@Produces({ "application/json" })
	public String editGame(@PathParam("winnerEmail") String winnerEmail, @PathParam("loserEmail") String loserEmail,
			@PathParam("refNum") Long refNum, @PathParam("count7Ball") boolean count7Ball) {
		return service.updateGame(winnerEmail, loserEmail, refNum, count7Ball);
	}

	public void setService(GameService service) {
		this.service = service;
	}

}
