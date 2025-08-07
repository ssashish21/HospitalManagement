package com.ashish.hospital.hospitalManagement;

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

    @Test
    public void addInsurance(){
        Insurance insurance = insuranceRepository.findById(5L).orElseThrow();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance, 2L);
        System.out.println(patient);

    }
}
