package com.ashish.hospital.hospitalManagement.dtos.appointment;

import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentResponse {
    private Long id;
    private LocalDateTime appointmentTime;
    private String reason;
    private Patient patient;
    private Doctor doctor;
}
