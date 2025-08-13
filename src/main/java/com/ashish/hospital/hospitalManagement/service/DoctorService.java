package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorResponse;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.entity.Patient;

import java.util.List;

public interface DoctorService {
    DoctorResponse createDoctor(DoctorCreateRequest doctor);
    List<DoctorResponse> getAllDoctors();
    DoctorResponse getDoctorById(Long id);
    DoctorResponse updateDoctor(Long id, DoctorUpdateRequest updatedDoctor);
    void deleteDoctor(Long id);
    List<Patient> getDoctorPatients(Long doctorId);
}
