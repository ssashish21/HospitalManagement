package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceRequest;
import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.entity.Insurance;

import java.util.List;

public interface InsuranceService {
    InsuranceResponse getInsuranceByPatientId(Long patientId);
    InsuranceResponse assignInsuranceToPatient(Long patientId, InsuranceRequest insuranceRequest);
    void removeInsuranceFromPatient(Long patientId);
    InsuranceResponse updateInsurance(Long insuranceId, InsuranceRequest updatedInsurance);
    List<InsuranceResponse> getAllInsurances();
    InsuranceResponse getInsuranceById(Long id);
    void deleteInsurance(Long id);
}
