package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);

    List<Patient> findByEmail(String email);

    List<Patient> findByBirthDate(LocalDateTime birthDate);
}
