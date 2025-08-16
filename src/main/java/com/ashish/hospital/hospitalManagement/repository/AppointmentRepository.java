package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
