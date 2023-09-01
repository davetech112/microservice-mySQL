package com.example.employeeservice.service;

import com.example.employeeservice.DTO.APIResponseDTO;
import com.example.employeeservice.DTO.EmployeeDTO;

public interface EmployeeService {
    EmployeeDTO saveEmployee(EmployeeDTO employeeDTO);
    APIResponseDTO getEmployeeById(Long id);
}
