package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}