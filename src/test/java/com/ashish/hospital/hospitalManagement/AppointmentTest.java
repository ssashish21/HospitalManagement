package com.ashish.hospital.hospitalManagement;

import com.ashish.hospital.hospitalManagement.dtos.appointment.AppointmentCreateRequest;
import com.ashish.hospital.hospitalManagement.repository.DoctorRepository;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest

public class AppointmentTest {
    @Mock
    private AppointmentService appointmentService;

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private DoctorRepository doctorRepository;

    @Test
    public void bookAppointment(){
        AppointmentCreateRequest request = new AppointmentCreateRequest();
        LocalDateTime appointmentTime = LocalDateTime.of(2025,8,16,10,15,0);
        request.setAppointmentTime(appointmentTime);
        request.setReason("Not feeling well from last 2 days, stomach Pain!");
        request.setPatientId(1L);
        request.setDoctorId(3L);
        appointmentService.bookAppointment(request);
    }
}
