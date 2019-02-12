package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.qa.service.PlayerService;


@Path("/player")
public class PlayerEndpoint {
	@Inject
	private PlayerService service;
	
	@Path("/getAllPlayers")
	@GET
	@Produces({"application/json"})
	public String getAllRecipes() {
		return service.getAllPlayers();
	}
	
	@Path("/getAPlayer/{email}")
	@GET
	@Produces({"application/json"})
	public String getAPlayer(@PathParam("email") String email) {
		return service.getAPlayer(email);
	}
	
	@Path("/createPlayer")
	@POST
	@Produces({"application/json"})
	public String addPlayer(String player) {
		return service.addPlayer(player);
	}
	
	@Path("/deletePlayer/{email}")
	@DELETE
	@Produces({"application/json"})
	public String deletePlayer(@PathParam("email") String email) {
		return service.deletePlayer(email);
	}
	
	@Path("/updatePlayer/{player}/{email}")
	@POST
	@Produces({"application/json"})
	public String editPlayer(@PathParam("player" + "email")String player ,String email) {
		return service.updatePlayer(player, email);
		
	}
}

