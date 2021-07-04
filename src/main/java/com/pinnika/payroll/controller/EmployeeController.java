package com.pinnika.payroll.controller;

import java.util.List;

import com.pinnika.payroll.entity.Employee;
import com.pinnika.payroll.exception.EmployeeNotFoundException;
import com.pinnika.payroll.repository.EmployeeRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private final EmployeeRepository repository;

    EmployeeController(EmployeeRepository repository) {
      this.repository = repository;
    }

    @GetMapping("/employees")
    List<Employee> all() {
      return (List<Employee>) repository.findAll();
    }

    @PostMapping("/employees")
    Employee newEmployee(@RequestBody Employee newEmployee) {
      return repository.save(newEmployee);
    }

    @GetMapping("/employees/{id}")
  Employee one(@PathVariable Long id) {
    System.out.println("id is="+id);
    return repository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
  }

}
