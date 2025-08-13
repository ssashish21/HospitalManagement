package com.ashish.hospital.hospitalManagement.mapper;

import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorResponse;
import com.ashish.hospital.hospitalManagement.dtos.doctor.DoctorUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorCreateRequest request);
    DoctorResponse toResponse(Doctor doctor);

    List<DoctorResponse> toResponseList(List<Doctor> doctors);

    void updateFromRequest(DoctorUpdateRequest request,@MappingTarget Doctor doctor);
}
