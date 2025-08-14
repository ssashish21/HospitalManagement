package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
