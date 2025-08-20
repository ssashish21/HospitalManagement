package com.ashish.hospital.hospitalManagement.mapper;

import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentUpdateRequest;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorDepartmentSummaryResponse;
import com.ashish.hospital.hospitalManagement.entity.Department;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {
    Department toEntity(DepartmentCreateRequest request);
    DepartmentResponse toResponse(Department department);

    List<DepartmentResponse> toResponseList(List<Department> departments);

    void updateFromRequest(DepartmentUpdateRequest request, @MappingTarget Department department);

    @Mapping(source = "headDoctor.id", target = "headDoctorId")
    DoctorDepartmentSummaryResponse toDoctorSummaryResponse(Department department);

     List<DoctorDepartmentSummaryResponse>  toDoctorSummaryResponseList(List<Department> departments);
}
