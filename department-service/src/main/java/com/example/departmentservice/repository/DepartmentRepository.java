package com.example.departmentservice.repository;

import com.example.departmentservice.entity.Department;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
     Department findDepartmentByDepartmentCode(String code);
}
