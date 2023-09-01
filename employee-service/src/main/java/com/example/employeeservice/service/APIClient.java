package com.example.employeeservice.service;

import com.example.employeeservice.DTO.DepartmentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTMENT-SERVICE")
public interface APIClient {
    @GetMapping("api/departments/{code}")
    DepartmentDTO getDepartmentByCode(@PathVariable String code);
}
