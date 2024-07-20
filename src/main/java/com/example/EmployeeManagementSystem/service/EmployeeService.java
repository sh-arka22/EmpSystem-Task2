package com.example.EmployeeManagementSystem.service;

import java.util.List;

import com.example.EmployeeManagementSystem.model.Employee;

public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public String removeEmployee(int id);

    public Employee findEmployeeById(int id);

    public List<Employee> getAllEmployees();

    public String updateEmployee(int id);
}
