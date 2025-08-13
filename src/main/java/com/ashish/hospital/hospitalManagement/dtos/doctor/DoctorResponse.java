package com.ashish.hospital.hospitalManagement.dtos.doctor;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorResponse {
    private Long id;
    private String name;
    private String specialization;
    private String email;
    private List<Long> appointmentIds; // Only sending IDs for simplicity
    private List<String> departmentNames; // Only sending department names
}
