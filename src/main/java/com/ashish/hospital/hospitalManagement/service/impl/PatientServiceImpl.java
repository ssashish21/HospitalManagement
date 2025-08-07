package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.DTOs.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.PatientMapper;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final PatientMapper patientMapper;

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    @Override
    public Patient updatePatient(Long id, PatientUpdateRequest updatedPatient) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id : " + id));

        patientMapper.updatePatientFromDto(updatedPatient, existing);
        return patientRepository.save(existing);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patientById = getPatientById(id);
        if(patientById != null){
            patientRepository.deleteById(id);
        } else {
            System.out.println("patient not found with id " + id);
        }
    }

    @Override
    public Insurance getPatientInsurance(Long patientId) {
        return null;
    }
}
