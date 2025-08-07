package com.ashish.hospital.hospitalManagement.mapper;

import com.ashish.hospital.hospitalManagement.DTOs.PatientUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface PatientMapper {
    void updatePatientFromDto(PatientUpdateRequest dto, @MappingTarget Patient patient);
}
