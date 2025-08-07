package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Insurance;
import com.ashish.hospital.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByName(String name);

    List<Patient> findByEmail(String email);

    List<Patient> findByBirthDate(LocalDateTime birthDate);

    @Query("SELECT p.insurance FROM Patient p WHERE p.id = :patientId")
    Optional<Insurance> findInsuranceByPatientId(@Param("patientId") Long patientId);

}
