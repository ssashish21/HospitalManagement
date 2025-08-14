package com.ashish.hospital.hospitalManagement.dtos.department;

import lombok.Data;

import java.util.Set;

@Data
public class DepartmentCreateRequest {
    private String name;
    private Long headDoctorId;
    private Set<Long> doctorIds;
}