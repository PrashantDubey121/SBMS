package com.example.employee_bonus.employee_bonus.dto;

import java.util.List;

public class EmployeeBonusResponse {
    private String currency;
    private List<EmployeeResponse> employees;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<EmployeeResponse> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeResponse> employees) {
        this.employees = employees;
    }

    public EmployeeBonusResponse(String currency, List<EmployeeResponse> employees) {
        this.currency = currency;
        this.employees = employees;
    }
}
