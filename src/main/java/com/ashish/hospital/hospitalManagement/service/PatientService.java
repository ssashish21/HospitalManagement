package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.DTOs.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient createPatient(Patient patient);
    List<Patient> getAllPatients();
    Patient getPatientById(Long id);
    Patient updatePatient(Long id, PatientUpdateRequest updatedPatient);
    void deletePatient(Long id);
    Insurance getPatientInsurance(Long patientId);
}
