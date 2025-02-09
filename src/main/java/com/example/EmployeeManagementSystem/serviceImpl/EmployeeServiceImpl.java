package com.example.EmployeeManagementSystem.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee addEmployee(Employee employee) {
        Employee emp = employeeRepo.save(employee);
        return emp;
    }

    @Override
    public String removeEmployee(int id) {
        // TODO Auto-generated method stub
        employeeRepo.deleteById(id);
        return "Deleted Succesfully";
    }

    public Employee findEmployeeById(int id) {
        // Fetch employee by id and throw NoSuchElementException if not found
        return employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee id " + id + " not found"));
    }

    @Override
    public List<Employee> getAllEmployees() {
        // TODO Auto-generated method stub
        List<Employee>empList = employeeRepo.findAll();
        return empList;
    }

    @Override
    public String updateEmployee(int id) {
        // TODO Auto-generated method stub
        Employee emp = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee id " + id + " not found"));

        Employee updatedEmp = new Employee();

        employeeRepo.save(updatedEmp);

        return "updated successfully";
    }

    @Override
    public Employee updateEmployee(int id, Employee employeeDetails) {
        // TODO Auto-generated method stub
        Employee existingEmployee = employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Employee id " + id + " not found"));

        if (employeeDetails.getName() != null) {
            existingEmployee.setName(employeeDetails.getName());
        }
        if (employeeDetails.getAge() != 0) {
            existingEmployee.setAge(employeeDetails.getAge());
        }
        if (employeeDetails.getState() != null) {
            existingEmployee.setState(employeeDetails.getState());
        }
        if (employeeDetails.getType() != null) {
            existingEmployee.setType(employeeDetails.getType());
        }
        if (employeeDetails.getSalary() != 0) {
            existingEmployee.setSalary(employeeDetails.getSalary());
        }

            return employeeRepo.save(existingEmployee);
    }
}
