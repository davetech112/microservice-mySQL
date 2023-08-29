package com.example.employeeservice.service.serviceimpl;

import com.example.employeeservice.DTO.EmployeeDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeDTO(
                savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail()
        );
    }

    @Override
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();
        return new EmployeeDTO(
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail()
        );

    }
}
