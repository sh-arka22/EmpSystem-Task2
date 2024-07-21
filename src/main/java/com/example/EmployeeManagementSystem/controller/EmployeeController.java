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

    // http://localhost:8080/emp/addEmp
    @PostMapping("/addEmp")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        Employee emp = employeeServiceImpl.addEmployee(employee);
        return new ResponseEntity<Employee>(emp, HttpStatus.CREATED);
    }

    // http://localhost:8080/emp/removeEmp/1
    @DeleteMapping("/removeEmp/{id}")
    public ResponseEntity<String> removeEmployee(@PathVariable int id){
        employeeServiceImpl.removeEmployee(id);
        return new ResponseEntity<String>("Removed Successfully", HttpStatus.ACCEPTED);
    }

    // http://localhost:8080/emp/findEmp/2
    @GetMapping("/findEmp/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable int id){
        Employee emps = employeeServiceImpl.findEmployeeById(id);
        return new ResponseEntity<Employee>(emps, HttpStatus.ACCEPTED);
    }

    // http://localhost:8080/emp/all
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> listOfEmployees(){
        List<Employee>listEmp = employeeServiceImpl.getAllEmployees();
        return new ResponseEntity<List<Employee>>(listEmp, HttpStatus.ACCEPTED);
    }


    /*
     * http://localhost:8080/emp/updateEmp/2
     * 
     * {
            "id": 2,
            "name": "updated name",
            "age": 30,
            "state": "delhi",
            "type": "private",
            "salary": 5000
        }
     */
    @PutMapping("/updateEmp/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeServiceImpl.updateEmployee(id, employeeDetails);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

}
