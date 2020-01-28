package com.logicbig.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Providers;

@Path("/")
public class MyResource {

    @GET
    @Path("{path}")
    public String create(@PathParam("path") String path,
                         @Context Providers providers) {
        ContextResolver<MyContext> cr = providers
                .getContextResolver(MyContext.class, MediaType.WILDCARD_TYPE);
        MyContext<String> c = cr.getContext(String.class);
        String r = c.get(path);
        return "response:  " + r;
    }
}