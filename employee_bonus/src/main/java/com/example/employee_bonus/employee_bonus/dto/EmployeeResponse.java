package com.example.employee_bonus.employee_bonus.dto;

public class EmployeeResponse {
    private String empName;
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public EmployeeResponse(String empName, Double amount) {
        this.empName = empName;
        this.amount = amount;
    }
}
