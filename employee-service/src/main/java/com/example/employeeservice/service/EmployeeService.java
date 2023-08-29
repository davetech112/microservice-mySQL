package com.example.employeeservice.service;

import com.example.employeeservice.DTO.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO getEmployeeById(Long id);
}
