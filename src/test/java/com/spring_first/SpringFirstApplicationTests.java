package com.spring_first;

import com.spring_first.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringFirstApplicationTests {

    @Autowired
    private EmployeeService employeeService;
    @Test
    void contextLoads() {
    }

}
