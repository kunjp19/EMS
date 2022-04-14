package com.example.EMS.controller;

import com.example.EMS.model.EmployeeDetails;
import com.example.EMS.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Fetches all the employees",
            notes = "Returns all the employees")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public List<EmployeeDetails> getEmployees() {
        return employeeService.getAllEmployee();
    }

    @GetMapping(value = "/zipCode/{zipcode}", produces = "application/json")
    @ApiOperation(value = "Fetches all the employees by zipcode",
            notes = "Returns all the employees")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public List<EmployeeDetails> getEmployeesByZipcode(@PathVariable("zipcode") int zipCode) {
        return employeeService.getAllByZipCode(zipCode);
    }

    @PostMapping(value = "/addEmployee", produces = "application/json")
    @ApiOperation(value = "save employee details")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "ADDED"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public String saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
            String employeeId = "Employee with " + employeeService.persistEmployeeDetais(employeeDetails) + "has been added/updated";
            log.info("Employee details has been added", employeeService.persistEmployeeDetais(employeeDetails));
            return employeeId;
    }

    @PostMapping(value = "/addEmployees", produces = "application/json")
    @ApiOperation(value = "save employee details")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "ADDED"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public String saveEmployeeDetailsByList(@RequestBody List<EmployeeDetails> listEmployeeDetails) {
        String rs = "Employees " + listEmployeeDetails.size()  + " has been added/updated";
        log.info("Employee details has been added");
        employeeService.saveAllEmployee(listEmployeeDetails);
        return rs;
    }

    @DeleteMapping(value = "/deleteEmployee/{id}", produces = "application/json")
    public void deleteEmployeeDetails(@PathVariable("id") Long employeeId) {
        employeeService.deleteEmployeeDetails(employeeId);
    }

}
