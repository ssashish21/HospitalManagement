package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Department;
import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.mapper.DepartmentMapper;
import com.ashish.hospital.hospitalManagement.repository.DepartmentRepository;
import com.ashish.hospital.hospitalManagement.repository.DoctorRepository;
import com.ashish.hospital.hospitalManagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final DoctorRepository doctorRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentResponse createDepartment(DepartmentCreateRequest request) {
        Department department = departmentMapper.toEntity(request);
        Department saved = departmentRepository.save(department);
        return departmentMapper.toResponse(saved);
    }

    @Override
    public List<DepartmentResponse> getAllDepartments() {
        return departmentMapper.toResponseList(departmentRepository.findAll());
    }

    @Override
    public DepartmentResponse getDepartmentById(Long id) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        return departmentMapper.toResponse(department);
    }

    @Override
    public DepartmentResponse updateDepartment(Long id, DepartmentUpdateRequest request) {
        Department department = departmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + id));
        departmentMapper.updateFromRequest(request, department);
        Department updated = departmentRepository.save(department);
        return departmentMapper.toResponse(updated);
    }

    @Override
    public void deleteDepartment(Long id) {
        if (!departmentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Department not found with id: " + id);
        }
        departmentRepository.deleteById(id);
    }

    @Override
    public DepartmentResponse assignHeadDoctor(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));

        department.setHeadDoctor(doctor);
        Department updated = departmentRepository.save(department);
        return departmentMapper.toResponse(updated);
    }

    @Override
    public DepartmentResponse addDoctorsToDepartment(Long departmentId, Set<Long> doctorIds) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        Set<Doctor> doctors = new HashSet<>(doctorRepository.findAllById(doctorIds));
        if (doctors.size() != doctorIds.size()) {
            throw new ResourceNotFoundException("Some doctors not found");
        }

        department.getDoctors().addAll(doctors);
        Department updated = departmentRepository.save(department);
        return departmentMapper.toResponse(updated);
    }

    @Override
    public DepartmentResponse removeDoctorFromDepartment(Long departmentId, Long doctorId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Department not found with id: " + departmentId));

        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id: " + doctorId));

        department.getDoctors().remove(doctor);
        Department updated = departmentRepository.save(department);
        return departmentMapper.toResponse(updated);
    }
}
