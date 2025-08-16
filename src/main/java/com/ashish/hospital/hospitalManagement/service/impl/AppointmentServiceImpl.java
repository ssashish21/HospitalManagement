package com.ashish.hospital.hospitalManagement.service.impl;

import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentCreateRequest;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentResponse;
import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentUpdateRequest;
import com.ashish.hospital.hospitalManagement.entity.Appointment;
import com.ashish.hospital.hospitalManagement.entity.Doctor;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.exception.ResourceNotFoundException;
import com.ashish.hospital.hospitalManagement.exception.SlotAlreadyBookedException;
import com.ashish.hospital.hospitalManagement.mapper.AppointmentMapper;
import com.ashish.hospital.hospitalManagement.repository.AppointmentRepository;
import com.ashish.hospital.hospitalManagement.repository.DoctorRepository;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.AppointmentService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final AppointmentMapper appointmentMapper;

    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Override
    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointmentMapper.toResponseList(appointments);
    }

    @Override
    @Transactional
    public AppointmentResponse bookAppointment(AppointmentCreateRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId())
                .orElseThrow(() -> new EntityNotFoundException("Patient not found with ID " + request.getPatientId()));

        Doctor doctor = doctorRepository.findById(request.getDoctorId())
                .orElseThrow(() -> new EntityNotFoundException("Doctor not found with ID " + request.getDoctorId()));

        Appointment appointment = appointmentMapper.toEntity(request);

        doctor.addAppointment(appointment);
        patient.addAppointment(appointment);

        try {
            Appointment savedAppointment = appointmentRepository.save(appointment);
            return appointmentMapper.toResponse(savedAppointment);
        } catch (DataIntegrityViolationException ex) {
            throw new SlotAlreadyBookedException("Slot already booked for doctor "
                    + request.getDoctorId() + " at " + request.getAppointmentTime());
        }
    }

    @Override
    @Transactional
    public AppointmentResponse updateAppointment(Long appointmentId, AppointmentUpdateRequest updateRequest) {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id : " + appointmentId));

        appointmentMapper.updateFromRequest(updateRequest,appointment);

        Appointment updatedAppointment = appointmentRepository.save(appointment);
        return appointmentMapper.toResponse(updatedAppointment);

    }

    @Override
    @Transactional
    public void cancelAppointment(Long appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Appointment not found with id : " + appointmentId));
        appointmentRepository.delete(appointment);
    }
}
