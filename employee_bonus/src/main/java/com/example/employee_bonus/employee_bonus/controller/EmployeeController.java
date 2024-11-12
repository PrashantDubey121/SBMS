package com.example.employee_bonus.employee_bonus.controller;

import com.example.employee_bonus.employee_bonus.EmployeeService;
import com.example.employee_bonus.employee_bonus.dto.EmployeeBonusResponse;
import com.example.employee_bonus.employee_bonus.dto.EmployeeRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tci")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employee-bonus")
    public ResponseEntity<String> addEmployees(@RequestBody EmployeeRequest employeeListRequest) {
        employeeService.saveEmployees(employeeListRequest.getEmployees());
        return ResponseEntity.ok("Employees added successfully.");
    }

    @GetMapping("/employee-bonus")
    public ResponseEntity<List<EmployeeBonusResponse>> getEmployeeBonus(
            @RequestParam("date") @DateTimeFormat(pattern = "MM-dd-yyyy") LocalDate date) {
        List<EmployeeBonusResponse> response = employeeService.getEligibleEmployees(date);
        return ResponseEntity.ok(response);
    }
}
