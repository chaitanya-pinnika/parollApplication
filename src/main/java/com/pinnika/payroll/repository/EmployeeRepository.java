package com.pinnika.payroll.repository;

import org.springframework.data.repository.CrudRepository;
import com.pinnika.payroll.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee,Long>{
    
}
