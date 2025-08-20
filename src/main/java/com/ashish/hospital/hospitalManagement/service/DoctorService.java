package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.dtos.doctor.*;
import com.ashish.hospital.hospitalManagement.entity.Patient;

import java.util.List;

public interface DoctorService {
    List<DoctorResponse> getAllDoctors();
    DoctorDetailResponse getDoctorById(Long id);

    List<DoctorAppointmentSummaryResponse> getAppointmentsByDoctorId(Long doctorId);
    List<DoctorDepartmentSummaryResponse> getDepartmentsByDoctorId(Long doctorId);

    DoctorDetailResponse createDoctor(DoctorCreateRequest doctor);
    DoctorDetailResponse updateDoctor(Long id, DoctorUpdateRequest updatedDoctor);
    void deleteDoctor(Long id);
}
