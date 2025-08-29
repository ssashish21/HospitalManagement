package com.ashish.hospital.hospitalManagement;

import com.ashish.hospital.hospitalManagement.dtos.patient.PatientResponse;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;
import com.ashish.hospital.hospitalManagement.repository.PatientRepository;
import com.ashish.hospital.hospitalManagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private PatientService patientService;

    @Test
    public void testPatientRepository(){
        List<Patient> patients = patientRepository.findAll();
    }

    @Test
    public void addPatient(){
        Patient patient = new Patient();
        patient.setName("Ashish");
        patient.setEmail("ashish@email.com");
        patient.setBirthDate(LocalDateTime.of(1997, 07,29, 10, 45));
        patient.setGender(Gender.MALE);
        patient.setBloodGroup(BloodGroupType.O_POSITIVE);
        patientRepository.save(patient);
    }

   // @Test
    public void getPatient(){
        var patient = patientService.getPatientById(2L);
        System.out.println(patient);
    }
}
