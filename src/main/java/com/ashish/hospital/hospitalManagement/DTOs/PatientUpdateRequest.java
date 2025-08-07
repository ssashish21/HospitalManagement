package com.ashish.hospital.hospitalManagement.DTOs;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PatientUpdateRequest {
    private String name;
    private String email;
    private LocalDate birthDate;
    private String gender;
    private String bloodGroup;
    private Long patientInsuranceId;
}
