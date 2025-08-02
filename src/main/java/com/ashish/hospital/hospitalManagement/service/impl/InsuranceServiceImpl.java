package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.repository.InsuranceRepository;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Override
    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with id " + patientId));

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return patient;
    }
}
