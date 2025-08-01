package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }
}
