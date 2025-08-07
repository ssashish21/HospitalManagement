package com.ashish.hospital.hospitalManagement.dtos.patient;

import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientResponse {
    private Long id;
    private String name;
    private LocalDateTime birthDate;
    private String email;
    private Gender gender;
    private LocalDateTime createdAt;
    private BloodGroupType bloodGroup;
    private Long insuranceId; // You can replace with InsuranceResponse if needed
}