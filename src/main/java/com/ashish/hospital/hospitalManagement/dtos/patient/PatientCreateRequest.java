package com.ashish.hospital.hospitalManagement.dtos.patient;

import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PatientCreateRequest {
    @NotBlank
    private String name;

    private LocalDateTime birthDate;
    @Email
    private String email;
    private Gender gender;
    private BloodGroupType bloodGroup;
    private Long insuranceId; // Reference
}
