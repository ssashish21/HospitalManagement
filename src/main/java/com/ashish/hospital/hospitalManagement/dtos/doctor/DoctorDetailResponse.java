package com.ashish.hospital.hospitalManagement.dtos.doctor;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoctorDetailResponse {
    private Long id;
    private String name;
    private String specialization;
    private String email;
}
