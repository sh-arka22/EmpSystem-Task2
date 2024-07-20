package com.example.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeManagementSystem.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
