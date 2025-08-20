package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientAppointmentSummaryResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;
import com.ashish.hospital.hospitalManagement.mapper.InsuranceMapper;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hospital/patients")
@RequiredArgsConstructor
public class PatientRestController {

    private final PatientService patientService;
    private final InsuranceMapper insuranceMapper;

    @GetMapping
    public ResponseEntity<List<PatientResponse>> getAllPatients() {
        List<PatientResponse> patients = patientService.getAllPatients();
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/filter")
    public ResponseEntity<List<PatientResponse>> getAllPatientByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Gender gender,
            @RequestParam(required = false) BloodGroupType bloodGroup
    ){
        List<PatientResponse> patients = patientService.getAllPatientsByFilters(name, gender, bloodGroup);
        return ResponseEntity.ok(patients);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientResponse> getPatientById(@PathVariable Long id) {
        PatientResponse patient = patientService.getPatientById(id);
        return ResponseEntity.ok(patient);
    }

    @GetMapping("/{id}/appointments")
    public  ResponseEntity<List<PatientAppointmentSummaryResponse>> getAppointmentById(@PathVariable Long id){
        List<PatientAppointmentSummaryResponse> appointments = patientService.getAppointmentsByPatientId(id);
        return ResponseEntity.ok(appointments);
    }

    @PostMapping
    public ResponseEntity<PatientResponse> createPatient(@RequestBody PatientCreateRequest patient) {
        PatientResponse createdPatient = patientService.createPatient(patient);
        return ResponseEntity
                .created(URI.create("/hospital/patients/" + createdPatient.getId()))
                .body(createdPatient);
    }


    @PutMapping("/{id}")
    public ResponseEntity<PatientResponse> updatePatient(@PathVariable Long id, @RequestBody PatientUpdateRequest updateRequest) {
        PatientResponse updatedPatient = patientService.updatePatient(id, updateRequest);
        return ResponseEntity.ok(updatedPatient);
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
