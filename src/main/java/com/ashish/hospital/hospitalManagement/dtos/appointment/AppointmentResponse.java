package com.ashish.hospital.hospitalManagement.dtos.appointment;

import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private PatientResponse patient;
    private DoctorResponse doctor;
}
