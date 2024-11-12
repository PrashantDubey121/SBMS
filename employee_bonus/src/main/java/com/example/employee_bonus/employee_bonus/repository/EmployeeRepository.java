package com.example.employee_bonus.employee_bonus.repository;

import com.example.employee_bonus.employee_bonus.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Custom queries if needed
}
