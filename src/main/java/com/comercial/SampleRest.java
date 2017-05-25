package com.comercial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class SampleRest {
    @GET
    @Path("/sample")
    @Produces(MediaType.APPLICATION_JSON)
    public String getSample() {
        return "Some JSON";
    }
}