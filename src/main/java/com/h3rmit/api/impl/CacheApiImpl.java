package com.h3rmit.api.impl;

import com.h3rmit.api.CacheApi;
import com.h3rmit.dto.CacheData;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("cache")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CacheApiImpl implements CacheApi {

    @POST
    public Response put(CacheData data) {
        return Response.status(Response.Status.OK).entity(data).build();
    }

    @GET
    public Response get() {
        return Response.status(Response.Status.OK).build();
    }

    @DELETE
    @Path("{key}")
    public Response remove(String key) {
        return Response.status(Response.Status.OK).build();
    }

    @POST
    @Path("clear")
    public Response clear() {
        return Response.status(Response.Status.OK).build();
    }
    
}
