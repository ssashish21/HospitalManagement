package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.doctor.*;
import com.ashish.hospital.hospitalManagement.entity.Appointment;
import com.ashish.hospital.hospitalManagement.entity.Department;
import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.AppointmentMapper;
import com.ashish.hospital.hospitalManagement.mapper.DepartmentMapper;
import com.ashish.hospital.hospitalManagement.mapper.DoctorMapper;
import com.ashish.hospital.hospitalManagement.repository.AppointmentRepository;
import com.ashish.hospital.hospitalManagement.repository.DepartmentRepository;
import com.ashish.hospital.hospitalManagement.repository.DoctorRepository;
import com.ashish.hospital.hospitalManagement.service.DoctorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    private final DepartmentRepository departmentRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public List<DoctorResponse> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        return doctorMapper.toResponseList(doctors);
    }

    @Override
    public DoctorDetailResponse getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Doctor not found with id " + id));
        return doctorMapper.toDetailResponse(doctor);
    }

    @Override
    public List<DoctorAppointmentSummaryResponse> getAppointmentsByDoctorId(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);

        return appointmentMapper.toDoctorSummaryResponseList(appointments);
    }

    @Override
    public List<DoctorDepartmentSummaryResponse> getDepartmentsByDoctorId(Long doctorId) {
        List<Department> departments = departmentRepository.findByDoctorId(doctorId);

        return departmentMapper.toDoctorSummaryResponseList(departments);
    }

    @Override
    public DoctorResponse createDoctor(DoctorCreateRequest request) {
        Doctor doctor = doctorMapper.toEntity(request);
        Doctor savedDoctor = doctorRepository.save(doctor);

        return doctorMapper.toResponse(savedDoctor);
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

}
