package com.spring_first.config;

import com.spring_first.model.Employee;
import com.spring_first.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataBaseLoader {

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository){
        return args -> {
            System.out.println("Database Loaded");
            Employee employee1 = new Employee("John", "Doe", LocalDate.now());
            Employee employee2 = new Employee("Dim", "Ser", LocalDate.now());
            employeeRepository.save(employee1);
            employeeRepository.save(employee2);
        };
    }
}
