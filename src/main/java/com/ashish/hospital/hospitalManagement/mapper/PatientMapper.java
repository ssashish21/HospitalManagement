package com.ashish.hospital.hospitalManagement.mapper;

import com.ashish.hospital.hospitalManagement.dtos.patient.PatientCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PatientMapper {
    Patient toPatientEntity(PatientCreateRequest request);
    PatientResponse toResponse(Patient patient);

    List<PatientResponse> toResponseList(List<Patient> patients);
    void updatePatientFromDto(PatientUpdateRequest dto, @MappingTarget Patient patient);
}
