package com.example.departmentservice.controller;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/departments")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;

    @PostMapping("/save")
    public ResponseEntity<DepartmentDTO> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO savedDepartment = departmentService.saveDepartment(departmentDTO);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<DepartmentDTO> getDepartmentByCode(@PathVariable String code){
        DepartmentDTO savedDepartment = departmentService.getDepartmentByCode(code);
        return new ResponseEntity<>(savedDepartment, HttpStatus.OK);
    }
}
