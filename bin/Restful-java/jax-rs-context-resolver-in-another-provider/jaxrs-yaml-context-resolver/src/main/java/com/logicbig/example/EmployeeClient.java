package com.logicbig.example;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * In this example we use plain YAML in the request
 */
public class EmployeeClient {
    private static Client client = ClientBuilder.newClient();
    private static WebTarget baseTarget = client.target("http://localhost:8080/employees");

    public static void main(String[] args) {
        reset();
        createEmployees();
        listEmployees();
    }

    private static void listEmployees() {
        System.out.println("-- getting employee list --");
        String response = baseTarget.request().get(String.class);
        System.out.println(response);
    }

    private static void createEmployees() {
        System.out.println("-- making PUT requests --");

        String[] employeesInYml = {
                "name: employee1\ndept: IT\n",
                "name: employee2\ndept: Admin\n",
                "name: employee3\ndept: Sale\n"
        };

        for (int i = 0; i < employeesInYml.length; i++) {
            WebTarget target = baseTarget.path(Integer.toString(i));
            Response r = target.request()
                               .put(Entity.entity(employeesInYml[i], "application/yaml"));
            System.out.println(r.readEntity(String.class));
        }
    }

    private static void reset() {
        baseTarget.request().delete();
    }
}