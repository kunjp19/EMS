package com.example.EMS.service;

import com.example.EMS.model.EmployeeDetails;
import com.example.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDetails> getAllEmployee() {
        return employeeRepository.findAll();
    }

}
