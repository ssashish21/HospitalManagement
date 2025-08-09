package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceRequest;
import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hospital/insurances")
@RequiredArgsConstructor
public class InsuranceRestController {

    private final InsuranceService insuranceService;

    @GetMapping("/patient/{id}")
    public ResponseEntity<InsuranceResponse> getInsuranceByPatientId(@PathVariable("id") Long patientId) {
        return ResponseEntity.ok(insuranceService.getInsuranceByPatientId(patientId));
    }

    @PostMapping("/patient/{id}")
    public InsuranceResponse assignInsuranceToPatient(@PathVariable("id") Long patientId, @RequestBody InsuranceRequest insuranceRequest) {
        return insuranceService.assignInsuranceToPatient(patientId, insuranceRequest);
    }

    @DeleteMapping("/patient/{id}")
    public void removeInsuranceFromPatient(@PathVariable("id") Long patientId) {
        insuranceService.removeInsuranceFromPatient(patientId);
    }

    @PutMapping("/{insuranceId}")
    public InsuranceResponse updateInsurance(@PathVariable Long insuranceId, @RequestBody InsuranceRequest updatedInsurance) {
        return insuranceService.updateInsurance(insuranceId, updatedInsurance);
    }

    @GetMapping
    public List<InsuranceResponse> getAllInsurances() {
        return insuranceService.getAllInsurances();
    }

    @GetMapping("/{id}")
    public InsuranceResponse getInsuranceById(@PathVariable Long id) {
        return insuranceService.getInsuranceById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteInsurance(@PathVariable Long id) {
        insuranceService.deleteInsurance(id);
    }
}
