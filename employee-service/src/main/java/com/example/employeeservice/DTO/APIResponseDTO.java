package com.example.employeeservice.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class APIResponseDTO {
    private DepartmentDTO department;
    private EmployeeDTO employee;
}
