package com.ashish.hospital.hospitalManagement.dtos.insurance;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceRequest {
    private String policyNumber;
    private String provider;
    private LocalDate validUntil;
}