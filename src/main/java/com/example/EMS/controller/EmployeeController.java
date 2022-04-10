package com.example.EMS.controller;

import com.example.EMS.model.EmployeeDetails;
import com.example.EMS.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
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

    @PostMapping(value = "/addEmployee", produces = "application/json")
    @ApiOperation(value = "save employee details")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "ADDED"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public void saveEmployeeDetails(@RequestBody EmployeeDetails employeeDetails) {
        if (!ObjectUtils.isEmpty(employeeService.persistEmployeeDetais(employeeDetails))) {
            log.info("Employee details has been added", employeeService.persistEmployeeDetais(employeeDetails));
        }
    }
}
