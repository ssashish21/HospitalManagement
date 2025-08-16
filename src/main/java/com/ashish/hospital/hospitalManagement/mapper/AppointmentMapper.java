package com.ashish.hospital.hospitalManagement.mapper;

import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment toEntity(AppointmentCreateRequest request);
    AppointmentResponse toResponse(Appointment appointment);
    void updateFromRequest(AppointmentUpdateRequest request,@MappingTarget Appointment appointment);

    List<AppointmentResponse> toResponseList(List<Appointment> appointments);
}
