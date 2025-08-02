package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;

public interface InsuranceService {
    Patient assignInsuranceToPatient(Insurance insurance, Long patientId);
}
