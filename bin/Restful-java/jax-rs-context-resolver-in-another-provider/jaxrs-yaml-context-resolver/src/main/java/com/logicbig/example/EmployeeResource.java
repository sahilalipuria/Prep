package com.logicbig.example;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("employees")
public class EmployeeResource {
    private static Set<Employee> employees = new HashSet<>();

    @PUT
    @Consumes("application/yaml")
    @Path("/{newId}")
    public String create(Employee employee,
                         @PathParam("newId") long newId) {
        employee.setId(Long.valueOf(newId));
        if (employees.contains(employee)) {
            throw new RuntimeException("Employee with id already exists: "
                    + newId);
        }
        employees.add(employee);
        return "Msg: employee created for id: " + newId;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public List<Employee> list() {
        return new ArrayList<>(employees);
    }

    @DELETE
    public void deleteAll(){
          employees.clear();
    }
}