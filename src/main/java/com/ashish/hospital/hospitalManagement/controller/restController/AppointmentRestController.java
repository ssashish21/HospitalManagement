package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentUpdateRequest;
import com.ashish.hospital.hospitalManagement.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/appointments")
@RequiredArgsConstructor
public class AppointmentRestController {

    private final AppointmentService appointmentService;

    // ✅ Get all appointments
    @GetMapping
    public ResponseEntity<List<AppointmentResponse>> getAllAppointments() {
        List<AppointmentResponse> appointments = appointmentService.getAllAppointments();
        return ResponseEntity.ok(appointments);
    }

    // ✅ Book a new appointment
    @PostMapping
    public ResponseEntity<AppointmentResponse> bookAppointment(
            @Valid @RequestBody AppointmentCreateRequest request) {
        AppointmentResponse response = appointmentService.bookAppointment(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // ✅ Update appointment
    @PutMapping("/{appointmentId}")
    public ResponseEntity<AppointmentResponse> updateAppointment(
            @PathVariable Long appointmentId,
            @Valid @RequestBody AppointmentUpdateRequest updateRequest) {
        AppointmentResponse response = appointmentService.updateAppointment(appointmentId, updateRequest);
        return ResponseEntity.ok(response);
    }

    // ✅ Cancel appointment
    @DeleteMapping("/{appointmentId}")
    public ResponseEntity<Void> cancelAppointment(@PathVariable Long appointmentId) {
        appointmentService.cancelAppointment(appointmentId);
        return ResponseEntity.noContent().build();
    }
}
