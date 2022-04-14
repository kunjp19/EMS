package com.example.EMS.service;

import com.example.EMS.model.EmployeeDetails;
import com.example.EMS.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<EmployeeDetails> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public List<EmployeeDetails> getAllByZipCode(int zipCode) {
        return employeeRepository.findAllByZipCode(zipCode);
    }

    public String persistEmployeeDetais (EmployeeDetails employeeDetails) {
        return String.valueOf(employeeRepository.save(employeeDetails).getEmpId());
    }

    @Transactional
    public void deleteEmployeeDetails (Long employeeId) {
        employeeRepository.deleteByEmpId(employeeId);
    }

    @Transactional
    public void saveAllEmployee(List<EmployeeDetails> employeeDetails) {
        employeeRepository.saveAll(employeeDetails);
    }

}
