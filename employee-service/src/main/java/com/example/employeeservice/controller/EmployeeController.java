package com.example.employeeservice.controller;

import com.example.employeeservice.DTO.EmployeeDTO;
import com.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("api/employees")
@AllArgsConstructor
public class EmployeeController {

    private EmployeeService service;

    @PostMapping("save-employee")
    public ResponseEntity<EmployeeDTO> saveEmployee(@RequestBody EmployeeDTO employee){
        EmployeeDTO employeeDTO = service.saveEmployee(employee);
        return new ResponseEntity<>(employeeDTO, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id){
        EmployeeDTO employeeDTO = service.getEmployeeById(id);
        return new ResponseEntity<>(employeeDTO, HttpStatus.OK);
    }
}
