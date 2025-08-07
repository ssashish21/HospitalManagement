package com.ashish.hospital.hospitalManagement.dtos.patient;

import lombok.Data;

@Data
public class PatientDTO {
    private Long id;
    private String name;
    private int age;
    private String gender;
    private String email;
}
