package com.ashish.hospital.hospitalManagement.dtos.doctor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorAppointmentSummaryResponse {
    private Long appointmentId;
    private Long patientId;
    private String patientName;
    private LocalDateTime appointmentTime;
    private String reason;
}
