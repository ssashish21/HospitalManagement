package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.dtos.patient.PatientAppointmentSummaryResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;

import java.util.List;

public interface PatientService {
    PatientResponse createPatient(PatientCreateRequest patient);
    List<PatientResponse> getAllPatients();
    PatientResponse getPatientById(Long id);
    List<PatientAppointmentSummaryResponse> getAppointmentsByPatientId(Long id);
    PatientResponse updatePatient(Long id, PatientUpdateRequest updatedPatient);
    void deletePatient(Long id);
    Insurance getPatientInsurance(Long patientId);
    List<PatientResponse> getAllPatientsByFilters(String name, Gender gender, BloodGroupType bloodGroup);
}
