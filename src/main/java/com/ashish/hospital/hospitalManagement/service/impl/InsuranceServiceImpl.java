package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceRequest;
import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.InsuranceMapper;
import com.ashish.hospital.hospitalManagement.repository.InsuranceRepository;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.InsuranceService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsuranceServiceImpl implements InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final InsuranceMapper insuranceMapper;
    private final PatientRepository patientRepository;

    @Override
    public InsuranceResponse getInsuranceByPatientId(Long patientId) {
        Insurance insurance = insuranceRepository.findByPatientId(patientId);
        return insuranceMapper.toResponse(insurance);
    }

    @Override
    @Transactional
    public InsuranceResponse assignInsuranceToPatient(Long patientId, InsuranceRequest insuranceRequest) {
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        Insurance insurance = insuranceMapper.toEntity(insuranceRequest);

        //Set the bidirectional link
        insurance.setPatient(patient);
        patient.setInsurance(insurance);

        Patient savedPatient = patientRepository.save(patient);

        return insuranceMapper.toResponse(savedPatient.getInsurance());
    }

    @Override
    @Transactional
    public void removeInsuranceFromPatient(Long patientId) {
        Patient patient = patientRepository.findById(patientId)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id " + patientId));

        Insurance insurance = patient.getInsurance();
        if(insurance == null){
            throw new IllegalStateException("Patient has no assigned insurance.");
        }

        patient.setInsurance(null);
        insurance.setPatient(null);

        patientRepository.save(patient);
        // insuranceRepository.delete(insurance); // we can skip this line already handled orphanRemoval = true
    }

    @Override
    @Transactional
    public InsuranceResponse updateInsurance(Long insuranceId, InsuranceRequest updatedRequest) {
        Insurance insurance = insuranceRepository.findById(insuranceId)
                .orElseThrow(()-> new ResourceNotFoundException("Insurance not found with id " + insuranceId));

        insuranceMapper.updateFromRequest(updatedRequest, insurance);

        insuranceRepository.save(insurance);
        return insuranceMapper.toResponse(insurance);
    }

    @Override
    public List<InsuranceResponse> getAllInsurances() {
        List<Insurance> insuranceList = insuranceRepository.findAll();
        return insuranceMapper.toResponseList(insuranceList);
    }

    @Override
    public InsuranceResponse getInsuranceById(Long id) {
        Insurance response = insuranceRepository.findById(id).orElseThrow();
        return insuranceMapper.toResponse(response);
    }

    @Override
    public void deleteInsurance(Long id) {
        throw new UnsupportedOperationException("Deleting insurance directly is not allowed.");
    }
}
