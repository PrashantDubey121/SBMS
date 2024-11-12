package com.example.employee_bonus.employee_bonus.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empName;
    private String currency;
    private LocalDate joiningDate;
    private LocalDate exitDate;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Constructors, getters, and setters


    public Employee() {
    }

    public Employee(Long id, String empName, String currency, LocalDate joiningDate, LocalDate exitDate, Double amount, Department department) {
        this.id = id;
        this.empName = empName;
        this.currency = currency;
        this.joiningDate = joiningDate;
        this.exitDate = exitDate;
        this.amount = amount;
        this.department = department;
    }

    public Employee(String john, String usd, LocalDate of, LocalDate of1, double v, Department itDept) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
