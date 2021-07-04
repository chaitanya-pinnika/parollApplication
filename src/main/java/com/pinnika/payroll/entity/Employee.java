package com.pinnika.payroll.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
public class Employee {
    private @Id @GeneratedValue Long id;
    private String name;
    private String role;

    Employee(){}

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
      }

      @Override
      public boolean equals(Object o) {
    
        if (this == o)
          return true;
        if (!(o instanceof Employee))
          return false;
        Employee employee = (Employee) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
            && Objects.equals(this.role, employee.role);
      }
    
      @Override
      public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
      }
}
