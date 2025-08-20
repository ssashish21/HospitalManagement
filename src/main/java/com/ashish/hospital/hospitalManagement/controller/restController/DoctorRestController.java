package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.doctor.*;
import com.ashish.hospital.hospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/doctors")
@RequiredArgsConstructor
public class DoctorRestController {

    private final DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getAllDoctors() {
        return ResponseEntity.ok(doctorService.getAllDoctors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorDetailResponse> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDoctorById(id));
    }

    @GetMapping("/{id}/appointments")
    public ResponseEntity<List<DoctorAppointmentSummaryResponse>> getAppointmentsByDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getAppointmentsByDoctorId(id));
    }

    @GetMapping("/{id}/departments")
    public ResponseEntity<List<DoctorDepartmentSummaryResponse>> getDepartmentsByDoctor(@PathVariable Long id) {
        return ResponseEntity.ok(doctorService.getDepartmentsByDoctorId(id));
    }

    @PostMapping
    public ResponseEntity<DoctorDetailResponse> createDoctor(@RequestBody DoctorCreateRequest request) {
        return ResponseEntity.ok(doctorService.createDoctor(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DoctorDetailResponse> updateDoctor(@PathVariable Long id, @RequestBody DoctorUpdateRequest request) {
        return ResponseEntity.ok(doctorService.updateDoctor(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}
