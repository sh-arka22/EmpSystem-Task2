package com.example.EmployeeManagementSystem.controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeManagementSystem.model.Employee;
import com.example.EmployeeManagementSystem.repository.EmployeeRepo;
import com.example.EmployeeManagementSystem.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeServiceImpl;
    
    @GetMapping("/home")
    public String homePage(){

        return "Welcome to Employee Management";
    }

    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee emp = employeeServiceImpl.addEmployee(employee);
        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }

    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id){
        employeeServiceImpl.removeEmployee(id);
        return new ResponseEntity<String>("Removed Successfully", HttpStatus.ACCEPTED);
    }

    @GetMapping("/findEmp/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        Employee emps = employeeServiceImpl.findEmployeeById(id);
        return new ResponseEntity<Employee>(emps, HttpStatus.ACCEPTED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> listOfEmployees(){
        List<Employee>listEmp = employeeServiceImpl.getAllEmployees();
        return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.ACCEPTED);
    }


}
