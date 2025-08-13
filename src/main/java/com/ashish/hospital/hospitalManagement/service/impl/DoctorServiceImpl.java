package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorResponse;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.DoctorMapper;
import com.ashish.hospital.hospitalManagement.repository.DoctorRepository;
import com.ashish.hospital.hospitalManagement.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest request) {
        Doctor doctor = doctorMapper.toEntity(request);
        Doctor savedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toResponse(savedDoctor);
    }

    @Override
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.toResponseList(doctors);
    }

    @Override
    public DoctorResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Doctor not found with id " + id));
        return doctorMapper.toResponse(doctor);
    }

    @Override
    @Transactional
    public DoctorResponse updateDoctor(Long id, DoctorUpdateRequest updatedDoctor) {
        Doctor existing = doctorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Doctor not found with id " + id));
        doctorMapper.updateFromRequest(updatedDoctor, existing);

        Doctor updated = doctorRepository.save(existing);

        return doctorMapper.toResponse(updated);
    }

    @Override
    public void deleteDoctor(Long id) {
        doctorRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Doctor not found with id " + id));
        doctorRepository.deleteById(id);
    }

    //TODO Once appointment impl is done
    @Override
    public List<Patient> getDoctorPatients(Long doctorId) {
        return List.of();
    }
}
