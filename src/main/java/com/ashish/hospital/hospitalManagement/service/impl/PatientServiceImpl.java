package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.patient.PatientAppointmentSummaryResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Appointment;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.AppointmentMapper;
import com.ashish.hospital.hospitalManagement.mapper.PatientMapper;
import com.ashish.hospital.hospitalManagement.repository.AppointmentRepository;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    private final PatientMapper patientMapper;
    private final AppointmentMapper appointmentMapper;

    @Override
    public PatientResponse createPatient(PatientCreateRequest request) {
        Patient patient = patientMapper.toPatientEntity(request);
        Patient savedPatient = patientRepository.save(patient);

        return patientMapper.toResponse(savedPatient);
    }

    @Override
    public List<PatientResponse> getAllPatients() {
        List<Patient> patients = patientRepository.findAll();
        List<PatientResponse> responsesList = new ArrayList<>();
        return patientMapper.toResponseList(patients);
    }

    @Override
    public PatientResponse getPatientById(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Patient not found with id: " + id));
        return patientMapper.toResponse(patient);
    }

    @Override
    public List<PatientAppointmentSummaryResponse> getAppointmentsByPatientId(Long id) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(id);
        return appointmentMapper.toPatientSummaryResponseList(appointments);
    }

    @Override
    public PatientResponse updatePatient(Long id, PatientUpdateRequest updatedPatient) {
        Patient existing = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not found with id : " + id));

        patientMapper.updatePatientFromDto(updatedPatient, existing);

        Patient updated = patientRepository.save(existing);

        return patientMapper.toResponse(updated);
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Patient not found with id: " + id));

        if(!patient.getAppointments().isEmpty()){
            throw new IllegalStateException("Patient cannot be deleted because appointments exist. Cancel appointments first.");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public Insurance getPatientInsurance(Long patientId) {
        return patientRepository.findInsuranceByPatientId(patientId)
                .orElseThrow(() -> new EntityNotFoundException("Insurance not found for patient with ID: " + patientId));
    }

    @Override
    public List<PatientResponse> getAllPatientsByFilters(String name, Gender gender, BloodGroupType bloodGroup) {
        List<Patient> patients = patientRepository.findAll().stream()
                .filter(p -> (name == null || p.getName().equalsIgnoreCase(name)))
                .filter(p -> ((gender == null) || (p.getGender() == gender)))
                .filter(p -> (bloodGroup == null || p.getBloodGroup() == bloodGroup))
                .toList();

        return patientMapper.toResponseList(patients);
    }
}
