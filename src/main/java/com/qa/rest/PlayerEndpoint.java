package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.business.PlayerService;

@Path("/player")
public class PlayerEndpoint {
	@Inject
	private PlayerService service;

	@Path("/getAllPlayers")
	@GET
	@Produces({ "application/json" })
	public String getAllPlayers() {
		return service.getAllPlayers();
	}

	@Path("/getAPlayerEmail/{email}")
	@GET
	@Produces({ "application/json" })
	public String getAPlayer(@PathParam("email") String email) {
		return service.getAPlayerEmail(email);
	}
	@Path("/getAPlayerName/{name}")
	@GET
	@Produces({ "application/json" })
	public String getAPlayerName(@PathParam("name") String name) {
		return service.getAPlayerName(name);
	}
	@Path("/getAPlayerWins/{wins}")
	@GET
	@Produces({ "application/json" })
	public String getAPlayerWins(@PathParam("wins") int wins) {
		return service.getAPlayerWins(wins);
	}
	@Path("/getAPlayerChamp/")
	@GET
	@Produces({ "application/json" })
	public String getAPlayerChamp() {
		return service.getAPlayerChamp();
	}

	@Path("/createPlayer")
	@POST
	@Produces({ "application/json" })
	public String addPlayer(String player) {
		return service.addPlayer(player);
	}
	
	@Path("/login/{email}/{password}")
	@POST
	@Produces({ "application/json" })
	public String login(@PathParam("email")String email,@PathParam("password") String password) {
		return service.login(email,password);
	}

	@Path("/deletePlayer/{email}")
	@DELETE
	@Produces({ "application/json" })
	public String deletePlayer(@PathParam("email") String email) {
		return service.deletePlayer(email);
	}

	@Path("/updatePlayer/{player}/{email}")
	@PUT
	@Produces({ "application/json" })
	public String editPlayer(@PathParam("player") String player,@PathParam("email") String email) {
		return service.updatePlayer(player, email);
	}

	public void setService(PlayerService service) {
		this.service = service;
	}
}
