package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
