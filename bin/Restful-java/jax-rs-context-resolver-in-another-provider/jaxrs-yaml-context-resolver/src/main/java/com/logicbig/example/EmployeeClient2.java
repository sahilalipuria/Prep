package com.logicbig.example;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class EmployeeClient2 {
    private static Client client = ClientBuilder.newBuilder()
                                                .register(YamlEntityProvider.class)
                                                .register(YamlContextResolver.class)
                                                .build();
    private static WebTarget baseTarget = client.target("http://localhost:8080/employees");

    public static void main(String[] args) {
        reset();
        createEmployees();
        listEmployees();
    }

    private static void listEmployees() {
        System.out.println("-- getting employee list --");
        List<Employee> employees = baseTarget.request().get(
                new GenericType<List<Employee>>() {
                });
        employees.forEach(System.out::println);
    }

    private static void createEmployees() {
        System.out.println("-- making PUT requests --");

        List<String> deptList = Arrays.asList("Admin", "IT", "Sale");
        for (int i = 1; i <= 5; i++) {
            Employee e = new Employee();
            e.setName("Employee" + i);
            int index = ThreadLocalRandom.current()
                                         .nextInt(0, 3);
            e.setDept(deptList.get(index));

            WebTarget target = baseTarget.path(Integer.toString(i));
            Response r = target.request()
                               .put(Entity.entity(e, "application/yaml"));
            System.out.println(r.readEntity(String.class));
        }
    }

    private static void reset() {
        baseTarget.request().delete();
    }
}