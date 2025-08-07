package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.patient.PatientCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.PatientMapper;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private PatientMapper patientMapper;

    @Override
    public PatientResponse createPatient(PatientCreateRequest request) {
        Patient patient = patientMapper.toPatientEntity(request);
        Patient savedPatient = patientRepository.save(patient);

        return patientMapper.toResponse(savedPatient);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponse> responsesList = new ArrayList<>();

        for(Patient patient: patients){
            responsesList.add(patientMapper.toResponse(patient));
        }

        return responsesList;
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + id));
        return patientMapper.toResponse(patient);
    }

    @Override
    public PatientResponse updatePatient(Long id, PatientUpdateRequest updatedPatient) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id : " + id));

        patientMapper.updatePatientFromDto(updatedPatient, existing);

        Patient updated = patientRepository.save(existing);

        return patientMapper.toResponse(updated);
    }

    @Override
    public void deletePatient(Long id) {
        patientRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Patient not found with id: " + id));

        patientRepository.deleteById(id);
    }

    //TODO
    @Override
    public Insurance getPatientInsurance(Long patientId) {
        return patientRepository.findInsuranceByPatientId(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Insurance not found for patient with ID: " + patientId));
    }
}
