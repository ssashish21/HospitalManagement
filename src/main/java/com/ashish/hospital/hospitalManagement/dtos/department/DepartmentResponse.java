package com.ashish.hospital.hospitalManagement.dtos.department;

import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentResponse {
    private Long id;
    private String name;
    private DoctorResponse headDoctor; // reuse DoctorResponse DTO
    private Set<DoctorResponse> doctors;
}