package com.ashish.hospital.hospitalManagement.repository;

import com.ashish.hospital.hospitalManagement.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
/*
   This is the native query

    @Query(
            value = "SELECT d.* FROM department d " +
                    "JOIN department_doctor dd ON d.id = dd.department_id " +
                    "WHERE dd.doctor_id = :doctorId",
            nativeQuery = true
    )

 */

    @Query("SELECT d FROM Department d JOIN d.doctors doc where doc.id = :doctorId")
    List<Department> findByDoctorId(@Param("doctorId") Long doctorId);


    /*

    SELECT d → we are selecting Department objects (not just IDs, the actual entity).
    FROM Department d → start from the Department entity.
    JOIN d.doctors doc → here comes the magic:

        d.doctors refers to the Set<Doctor> inside the Department entity.
        JPA knows this is a @ManyToMany relationship → so under the hood it joins department, department_doctor (join table), and doctor.

        doc is just an alias for each Doctor in that set.

    WHERE doc.id = :doctorId → filter only those departments that have a doctor with the given ID.
    */
}
