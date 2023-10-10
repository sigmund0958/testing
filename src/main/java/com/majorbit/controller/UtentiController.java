package com.majorbit.controller;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.majorbit.model.Utenti;
import com.majorbit.repository.UtentiDAOImpl;
import com.majorbit.repository.UtentiPreparedDAOImpl;

@Path("/utenti")
public class UtentiController {
	
	private UtentiDAOImpl dao=  UtentiDAOImpl.getInstance();
	private UtentiPreparedDAOImpl daoPrep= UtentiPreparedDAOImpl.getInstance();
	
	@POST
	@Path("/standard")
	public Response create(Utenti u) {
		Integer id= u.getId();
		Utenti check= dao.read(id);
		if(check.getId()==null) {
			dao.create(u);
			return Response.status(Status.OK).entity("Utente creato").build();
		}else {
			return Response.status(Status.OK).entity("L'utente esiste gia'").build();
		}
	}

	@GET
	@Path("/ping")
	public Response ping(){
		String risposta = "pong";
		return Response.status(Status.OK).entity(risposta).build();
	}
	
	@POST
	@Path("/prepared")
	public Response createPrep(Utenti u) {
		Integer id= u.getId();
		Utenti check= daoPrep.read(id);
		if(check.getId()==null) {
			daoPrep.create(u);
			return Response.status(Status.OK).entity("Utente creato").build();
		}else {
			return Response.status(Status.OK).entity("L'utente esiste gia'").build();
		}
	}

	@GET
	@Path("/standard")
	public Response read(@QueryParam("id")Integer id) {
		Utenti check= dao.read(id);
		if(check.getId()!=null) {
			return Response.status(Status.OK).entity(check).build();
		}else {
			return Response.status(Status.OK).entity("L'utente non esiste").build();
		}
	}
	@GET
	@Path("/prepared")
	public Response readPrep(@QueryParam("id")Integer id) {
		Utenti check= daoPrep.read(id);
		if(check.getId()!=null) {
			return Response.status(Status.OK).entity(check).build();
		}else {
			return Response.status(Status.OK).entity("L'utente non esiste").build();
		}
	}
	
	@GET
	@Path("/bang")
	public Response bang(){
		String risposta = "baaaaang";
		return Response.status(Status.OK).entity(risposta).build();
	}
}
