package com.ashish.hospital.hospitalManagement.dtos.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDepartmentSummaryResponse {
    private Long id;
    private String name;
    private Long headDoctorId;
}
