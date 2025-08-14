package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentUpdateRequest;

import java.util.List;
import java.util.Set;

public interface DepartmentService {
    DepartmentResponse createDepartment(DepartmentCreateRequest request);
    List<DepartmentResponse> getAllDepartments();
    DepartmentResponse getDepartmentById(Long id);
    DepartmentResponse updateDepartment(Long id, DepartmentUpdateRequest request);
    void deleteDepartment(Long id);

    DepartmentResponse assignHeadDoctor(Long departmentId, Long doctorId);
    DepartmentResponse addDoctorsToDepartment(Long departmentId, Set<Long> doctorIds);
    DepartmentResponse removeDoctorFromDepartment(Long departmentId, Long doctorId);
}
