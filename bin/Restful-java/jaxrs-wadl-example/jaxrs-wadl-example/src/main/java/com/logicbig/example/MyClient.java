package com.logicbig.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

public class MyClient {
    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://localhost:8080/jaxrs-wadl-example/application.wadl" );
        Response response = target.request()
                                  .get();
        System.out.printf("status: %s%n", response.getStatus());

        MultivaluedMap<String, Object> headers = response.getHeaders();
        System.out.println("-- response headers --");
        headers.entrySet().forEach(e-> System.out.printf("%s: %s%n", e.getKey(), e.getValue()));
        System.out.printf("-- response body --%n%s%n", response.readEntity(String.class));
    }
}