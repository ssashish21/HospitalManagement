package com.ashish.hospital.hospitalManagement;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceRequest;
import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.repository.InsuranceRepository;
import com.ashish.hospital.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private InsuranceRepository insuranceRepository;


    public void addInsurance(){

        InsuranceResponse patient = insuranceService.assignInsuranceToPatient(1L,new InsuranceRequest());
        System.out.println(patient);

    }
}
