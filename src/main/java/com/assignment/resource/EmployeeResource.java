package com.assignment.resource;

import com.assignment.model.Employee;
import com.assignment.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employee")
public class EmployeeResource {

    @Inject
    private EmployeeService employeeService;

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/add")
    public Response addEmployee(Employee employee) {
        Employee createdEmployee = employeeService.addEmployee(employee);
        return Response.status(Response.Status.CREATED).entity(createdEmployee).build();
    }

    @DELETE
    @Produces("application/json")
    @Path("/delete/id/{id}")
    public Response deleteEmployee(@PathParam("id") int id) {
        employeeService.deleteEmployee(id);
        return Response.ok().build();
    }

    @GET
    @Produces("application/json")
    @Path("/id/{id}")
    public Response getEmployee(@PathParam("id") int id) {
        Employee employee = employeeService.getEmployee(id);
        return Response.ok().entity(employee).build();

    }

    @GET
    @Produces("application/json")
    public Response getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        return Response.ok().entity(employeeList).build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/update")
    public Response updateEmployee(Employee employee){
       Employee updatedEmployee =  employeeService.updateEmployee(employee);
       return Response.ok().entity(updatedEmployee).build();
    }

}
