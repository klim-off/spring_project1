package com.spring_first.service;

import com.spring_first.exceptions.EmployeeNotFoundException;
import com.spring_first.model.Employee;
import com.spring_first.repository.EmployeeRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Cacheable
    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }
    @Transactional
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findByFirstName(String firstName) {

        return employeeRepository.findAllByFirstName(firstName);
    }

    public Employee findById(Long id) {
        var employee = employeeRepository.findById(id);
        if (employee.isEmpty()){
            throw new EmployeeNotFoundException();
        }
        return  employee.get();
    }
}
