package com.ashish.hospital.hospitalManagement.dtos.appointment;

import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AppointmentCreateRequest {
    @NotBlank
    private LocalDateTime appointmentTime;

    @NotEmpty
    @Min(10) @Max(500)
    private String reason;

    @NotNull
    private Long patientId;

    @NotNull
    private Long doctorId;
}
