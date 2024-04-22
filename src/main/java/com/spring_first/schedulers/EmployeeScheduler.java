package com.spring_first.schedulers;

import com.spring_first.model.Employee;
import com.spring_first.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmployeeScheduler {
    public final EmployeeRepository employeeRepository;

    @Scheduled(fixedRate = 5000)
    public void scheduledTask(){
        log.info("Creating employee scheduled task");
        var employee = new Employee("Sem", "Dwer", LocalDate.now());
        employeeRepository.save(employee);
    }
}
