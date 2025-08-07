package com.ashish.hospital.hospitalManagement.dtos.patient;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PatientCreateRequest {
    @NotBlank
    private String name;

    @Min(0) @Max(100)
    private int age;

    @NotBlank
    private String gender;

    @Email
    private String email;
}
