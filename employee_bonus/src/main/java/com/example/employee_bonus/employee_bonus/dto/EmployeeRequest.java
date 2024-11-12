package com.example.employee_bonus.employee_bonus.dto;

import com.example.employee_bonus.employee_bonus.config.CustomLocalDateDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.LocalDate;
import java.util.List;

public class EmployeeRequest {
    private String empName;
    private String department;
    private Double amount;
    private String currency;
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate joiningDate;
    @JsonDeserialize(using = CustomLocalDateDeserializer.class)
    private LocalDate exitDate;
    private List<EmployeeRequest> employees;

    public List<EmployeeRequest> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeRequest> employees) {
        this.employees = employees;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }
}
