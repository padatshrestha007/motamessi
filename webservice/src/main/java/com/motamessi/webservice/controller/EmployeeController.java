package com.motamessi.webservice.controller;

import java.util.List;

import com.motamessi.webservice.exception.ResourceNotFoundException;
import com.motamessi.webservice.model.Employee;
import com.motamessi.webservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository empRepo;

    //create employee
    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee newEmployee)
    {
        empRepo.save(newEmployee);
        return  ResponseEntity.ok("Created!");
    }

    //get all employees
    @GetMapping
    public List<Employee> getAllEmployees(){
        return empRepo.findAll();
    }

    //get employee by id
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee emp =  empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"+id));
        return ResponseEntity.ok(emp);
    }

    //update employee
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails)
    {
        Employee updateEmp = empRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not found"+id));
        updateEmp.setFirstName(employeeDetails.getFirstName());
        updateEmp.setLastName(employeeDetails.getLastName());
        updateEmp.setEmailId(employeeDetails.getEmailId());
        empRepo.save(updateEmp);
        return ResponseEntity.ok(updateEmp);
    }
}
