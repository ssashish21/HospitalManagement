package com.ashish.hospital.hospitalManagement.controller.restController;

import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.department.DepartmentUpdateRequest;
import com.ashish.hospital.hospitalManagement.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/hospital/departments")
@RequiredArgsConstructor
public class DepartmentRestController {

    private final DepartmentService departmentService;

    // Create Department
    @PostMapping
    public ResponseEntity<DepartmentResponse> createDepartment(
            @RequestBody DepartmentCreateRequest request) {
        return ResponseEntity.ok(departmentService.createDepartment(request));
    }

    // Get All Departments
    @GetMapping
    public ResponseEntity<List<DepartmentResponse>> getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    // Get Department by ID (with doctors if service fetches them)
    @GetMapping("/{id}")
    public ResponseEntity<DepartmentResponse> getDepartmentById(@PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    // Update Department
    @PutMapping("/{id}")
    public ResponseEntity<DepartmentResponse> updateDepartment(
            @PathVariable Long id,
            @RequestBody DepartmentUpdateRequest request) {
        return ResponseEntity.ok(departmentService.updateDepartment(id, request));
    }

    // Delete Department
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
        return ResponseEntity.noContent().build();
    }

    // Assign Head Doctor
    @PutMapping("/{departmentId}/head-doctor/{doctorId}")
    public ResponseEntity<DepartmentResponse> assignHeadDoctor(
            @PathVariable Long departmentId,
            @PathVariable Long doctorId) {
        return ResponseEntity.ok(departmentService.assignHeadDoctor(departmentId, doctorId));
    }

    // Add Multiple Doctors to the Department
    @PostMapping("/{departmentId}/doctors")
    public ResponseEntity<DepartmentResponse> addDoctorsToDepartment(@PathVariable Long departmentId, @RequestBody Set<Long> doctorIds) {
        return ResponseEntity.ok(departmentService.addDoctorsToDepartment(departmentId, doctorIds));
    }

    // Remove a Doctor from the Department
    @DeleteMapping("/{departmentId}/doctors/{doctorId}")
    public ResponseEntity<DepartmentResponse> removeDoctorFromDepartment(
            @PathVariable Long departmentId,
            @PathVariable Long doctorId) {
        return ResponseEntity.ok(departmentService.removeDoctorFromDepartment(departmentId, doctorId));
    }
}

