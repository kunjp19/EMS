package com.example.EMS.repository;

import com.example.EMS.model.EmployeeDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDetails, Long> {

    void deleteByEmpId(Long employeeId);

}
