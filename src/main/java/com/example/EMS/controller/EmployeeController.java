package com.example.EMS.controller;

import com.example.EMS.model.EmployeeDetails;
import com.example.EMS.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping(produces = "application/json")
    @ApiOperation(value = "Fetches all the orders",
            notes = "Returns all the orders")
    @ApiResponses(value={
            @ApiResponse(code=302,message = "FOUND"),
            @ApiResponse(code=500,message = "Interval Server Error"),
            @ApiResponse(code=200,message = "OK")
    })
    public List<EmployeeDetails> getEmployees() {
        return employeeService.getAllEmployee();
    }
}
