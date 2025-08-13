package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorResponse;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/doctors")
@RequiredArgsConstructor
public class DoctorRestController {

    private final DoctorService doctorService;

    @PostMapping
    public DoctorResponse createDoctor(@RequestBody DoctorCreateRequest doctor) {
        return doctorService.createDoctor(doctor);
    }

    @GetMapping
    public List<DoctorResponse> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public DoctorResponse getDoctorById(@PathVariable Long id) {
        return doctorService.getDoctorById(id);
    }

    @PutMapping("/{id}")
    public DoctorResponse updateDoctor(@PathVariable Long id, @RequestBody DoctorUpdateRequest updatedDoctor) {
        return doctorService.updateDoctor(id, updatedDoctor);
    }

   @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable  Long id) {
        doctorService.deleteDoctor(id);
    }

    @GetMapping("/{id}/patients")
    public List<Patient> getDoctorPatients(@PathVariable Long doctorId) {
        return List.of();
    }
}
