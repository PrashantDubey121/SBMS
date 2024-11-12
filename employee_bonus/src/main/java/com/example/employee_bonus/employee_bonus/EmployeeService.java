package com.example.employee_bonus.employee_bonus;

import com.example.employee_bonus.employee_bonus.dto.EmployeeBonusResponse;
import com.example.employee_bonus.employee_bonus.dto.EmployeeRequest;
import com.example.employee_bonus.employee_bonus.dto.EmployeeResponse;
import com.example.employee_bonus.employee_bonus.entity.Department;
import com.example.employee_bonus.employee_bonus.entity.Employee;
import com.example.employee_bonus.employee_bonus.repository.DepartmentRepository;
import com.example.employee_bonus.employee_bonus.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeService(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    public void saveEmployees(List<EmployeeRequest> employeeRequests) {
        for (EmployeeRequest request : employeeRequests) {
            Department department = departmentRepository.findByName(request.getDepartment());
            if (department == null) {
                department = new Department(request.getDepartment());
                departmentRepository.save(department);
            }

            Employee employee = new Employee();
            employee.setEmpName(request.getEmpName());
            employee.setCurrency(request.getCurrency());
            employee.setJoiningDate(request.getJoiningDate());
            employee.setExitDate(request.getExitDate());
            employee.setAmount(request.getAmount());
            employee.setDepartment(department);
            employeeRepository.save(employee);
        }
    }

    public List<EmployeeBonusResponse> getEligibleEmployees(LocalDate date) {
        List<Employee> employees = employeeRepository.findAll();

        Map<String, List<EmployeeResponse>> groupedByCurrency = employees.stream()
                .filter(emp -> emp.getJoiningDate() != null &&
                        emp.getExitDate() != null &&!date.isBefore(emp.getJoiningDate()) && !date.isAfter(emp.getExitDate()))
                .collect(Collectors.groupingBy(
                        Employee::getCurrency,
                        Collectors.mapping(emp -> new EmployeeResponse(emp.getEmpName(), emp.getAmount()), Collectors.toList())
                ));

        return groupedByCurrency.entrySet().stream()
                .map(entry -> new EmployeeBonusResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }
}
