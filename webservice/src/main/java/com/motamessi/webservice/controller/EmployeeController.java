package com.motamessi.webservice.controller;

import java.util.List;
import com.motamessi.webservice.model.Employee;
import com.motamessi.webservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository empRepo;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return empRepo.findAll();
    }
}
