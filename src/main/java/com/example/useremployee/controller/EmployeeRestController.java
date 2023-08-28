package com.example.useremployee.controller;

import com.example.useremployee.model.Employee;
import com.example.useremployee.model.User;
import com.example.useremployee.repositories.EmployeeRepository;
import com.example.useremployee.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping (path = "employees")
    public List<Employee> findEmployees() {
    return employeeRepository.findAll();
    }

    @PostMapping (path = "employee")
    @ResponseStatus(HttpStatus.CREATED)
    public Employee postEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return employeeRepository.save(employee);
    }

    @PostMapping("/useremp")
    public User postUserEmployee(@RequestBody Employee employee) {
        System.out.println(employee);
        return userRepository.save(employee.getUser());
    }


}
