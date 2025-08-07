package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.mapper.InsuranceMapper;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hospital/patients")
public class PatientRestController {
    @Autowired
    private PatientService patientService;

    @Autowired
    private InsuranceMapper insuranceMapper;

    @PostMapping
    public PatientResponse createPatient(@RequestBody PatientCreateRequest patient){
        return patientService.createPatient(patient);
    }

    @GetMapping
    public List<PatientResponse> getAllPatients(){
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public PatientResponse getPatientById(@PathVariable Long id){
        return patientService.getPatientById(id);
    }

    @PutMapping("/{id}")
    public PatientResponse updatePatient(@PathVariable Long id, @RequestBody PatientUpdateRequest updateRequest){
        return patientService.updatePatient(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/insurance")
    public ResponseEntity<InsuranceResponse> getPatientInsurance(@PathVariable Long id) {
        Insurance insurance = patientService.getPatientInsurance(id);
        InsuranceResponse response = insuranceMapper.toResponse(insurance);
        return ResponseEntity.ok(response);
    }
}

