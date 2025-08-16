package com.ashish.hospital.hospitalManagement.service;

import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentUpdateRequest;

import java.util.List;

public interface AppointmentService {
    List<AppointmentResponse> getAllAppointments();
    AppointmentResponse bookAppointment(AppointmentCreateRequest request);
    AppointmentResponse updateAppointment(Long appointmentId, AppointmentUpdateRequest updateRequest);
    void cancelAppointment(Long appointmentId);
}
