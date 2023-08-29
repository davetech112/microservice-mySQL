package com.example.departmentservice.service.serviceImpl;

import com.example.departmentservice.dto.DepartmentDTO;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDTO saveDepartment(DepartmentDTO departmentDTO) {
        Department department = new Department(
                departmentDTO.getId(),

                departmentDTO.getDepartmentName(),
                departmentDTO.getDepartmentDescription(),
                departmentDTO.getDepartmentCode()
        );

        Department savedDept = departmentRepository.save(department);

        DepartmentDTO newDept = new DepartmentDTO(
                savedDept.getId(),
                savedDept.getDepartmentName(),
                savedDept.getDepartmentDescription(),
                savedDept.getDepartmentCode()
        );
        return newDept;
    }

    @Override
    public DepartmentDTO getDepartmentByCode(String departmentCode) {
        Department department = departmentRepository.findDepartmentByDepartmentCode(departmentCode);
        return new DepartmentDTO(
                department.getId(), department.getDepartmentName(),department.getDepartmentDescription(), department.getDepartmentCode()
        );
    }
}
