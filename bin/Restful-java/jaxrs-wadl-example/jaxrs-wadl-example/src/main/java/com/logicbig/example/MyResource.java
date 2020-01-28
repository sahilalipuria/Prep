package com.logicbig.example;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/")
public class MyResource {

    @Path("/test")
    @GET
    public Response handle() {
        Response r = Response.ok("test with GET, body content")
                             .build();
        return r;
    }


    @Path("/test2")
    @GET
    public Response handle2() {
        Response r = Response.ok("test2 with GET, body content")
                             .build();
        return r;
    }

    @Path("/test2")
    @POST
    public Response handle3() {
        Response r = Response.ok("test2 with POST, body content")
                             .build();
        return r;
    }

    @Path("/test2")
    @HEAD
    public Response handle4() {
        Response r = Response.ok("test2 with HEAD, body content")
                             .build();
        return r;
    }

    @Path("/test3")
    @GET
    public Response handle5() {
        Response r = Response.ok("test3 with GET, body content")
                             .build();
        return r;
    }

    @Path("/test3")
    @OPTIONS
    public Response handle6() {
        Response r = Response.ok("test3 with OPTIONS, body content")
                             .header("Allow", "GET")
                             .header("Allow", "OPTIONS")
                             .build();
        return r;
    }

    @Path("/test4")
    @DELETE
    public Response handle7() {
        Response r = Response.ok("test4 with DELETE, body content")
                             .build();
        return r;
    }

    @Path("/test4")
    @PUT
    public Response handle8() {
        Response r = Response.ok("test4 with PUT, body content")
                             .build();
        return r;
    }
}