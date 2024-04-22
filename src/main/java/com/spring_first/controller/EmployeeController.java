package com.spring_first.controller;

import com.spring_first.model.Employee;
import com.spring_first.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Cacheable("employees")
    @GetMapping("/employees")
    public List <Employee> findAllEmployees(){
        return employeeService.findAllEmployee();
    }

    @GetMapping("/employees")
    public List<Employee> findEmployeeByFirstName(@RequestParam(required = false) String firstName){
        if (firstName.isEmpty() || firstName == null){
            return employeeService.findAllEmployee();
        }
        return employeeService.findByFirstName(firstName);
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable Long id){
        return employeeService.findById(id);

    }

    @PostMapping("/employees")
    public Employee createEmployee (@RequestBody Employee employee){
      return employeeService.create(employee);
    }

}
