package com.ashish.hospital.hospitalManagement.dtos.patient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientAppointmentSummaryResponse {
    private Long appointmentId;
    private Long doctorId;
    private String doctorName;
    private LocalDateTime appointmentTime;
    private String reason;
}
