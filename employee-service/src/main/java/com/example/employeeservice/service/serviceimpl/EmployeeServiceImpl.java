package com.example.employeeservice.service.serviceimpl;

import com.example.employeeservice.DTO.APIResponseDTO;
import com.example.employeeservice.DTO.DepartmentDTO;
import com.example.employeeservice.DTO.EmployeeDTO;
import com.example.employeeservice.entity.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import com.example.employeeservice.service.APIClient;
import com.example.employeeservice.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;
   // private RestTemplate restTemplate;
    //private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setEmail(employeeDTO.getEmail());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setDepartmentCode(employeeDTO.getDepartmentCode());

        Employee savedEmployee = employeeRepository.save(employee);

        return new EmployeeDTO(
                savedEmployee.getId(), savedEmployee.getFirstName(), savedEmployee.getLastName(), savedEmployee.getEmail(), savedEmployee.getDepartmentCode()
        );
    }

    @Override
    public APIResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id).get();

        //Rest Template
//        ResponseEntity<DepartmentDTO> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/departments/" + employee.getDepartmentCode(), DepartmentDTO.class);
//        DepartmentDTO departmentDTO = responseEntity.getBody();


        //webClient
//        DepartmentDTO departmentDTO = webClient.get()
//                .uri("http://localhost:8080/api/departments/" + employee.getDepartmentCode())
//                .retrieve().bodyToMono(DepartmentDTO.class)
//                .block();


        //feignClient
        DepartmentDTO departmentDTO = apiClient.getDepartmentByCode(employee.getDepartmentCode());

        EmployeeDTO employeeDTO = new EmployeeDTO(
                employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail(), employee.getDepartmentCode()
        );
        APIResponseDTO apiResponseDTO = new APIResponseDTO();
        apiResponseDTO.setEmployee(employeeDTO);
        apiResponseDTO.setDepartment(departmentDTO);
        return apiResponseDTO;
    }
}
