package com.logicbig.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class JaxRsClient {

    public static void main(String[] args) {
        Client client = ClientBuilder.newClient();
        WebTarget baseTarget = client.target("http://localhost:8080/jaxrs-context-resolver-example/example");
        String response = baseTarget.request()
                                    .get(String.class);
        System.out.println(response);
    }
}