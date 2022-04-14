package com.example.EMS.repository;

import com.example.EMS.model.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDetails, Long> {

    List<EmployeeDetails> findAll();

    EmployeeDetails save(EmployeeDetails employeeDetails);

    void deleteByEmpId(Long employeeId);

    List<EmployeeDetails> findAllByZipCode(int zipCode);

}
