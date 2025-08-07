package com.ashish.hospital.hospitalManagement.mapper;

import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceRequest;
import com.ashish.hospital.hospitalManagement.dtos.insurance.InsuranceResponse;
import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.entity.Insurance;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring")
public interface InsuranceMapper {
    Insurance toEntity(InsuranceRequest request);
    InsuranceResponse toResponse(Insurance insurance);

    List<InsuranceResponse> toResponseList(List<Insurance> insurances);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateFromRequest(InsuranceRequest request, @MappingTarget Insurance insurance);
}