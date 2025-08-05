package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.repository.DoctorRepository;
import com.ashish.hospital.hospitalManagement.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public Doctor getDoctorById(Long id) {
        return doctorRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Doctor not found with id " + id));
    }
}
