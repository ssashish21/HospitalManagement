package com.ashish.hospital.hospitalManagement.entity;

import com.ashish.hospital.hospitalManagement.entity.enums.BloodGroupType;
import com.ashish.hospital.hospitalManagement.entity.enums.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = {
                //@UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}), // for a single column we can directly set unique = true
                @UniqueConstraint(name = "unique_patient_name_birthDate", columnNames = {"name", "birthDate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthDate")
        }
)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    @ToString.Exclude
    private LocalDateTime birthDate;

    @Column(unique = true, nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    //@OneToOne(cascade = {MERGE, PERSIST}) // owning side
    @OneToOne(cascade = {ALL}, orphanRemoval = true) // I want to remove the orphan record(insurance) once I detach from insurance
    @JoinColumn(name = "patient_insurance_id") // Here we renamed it otherwise auto create join column insurance_id
    private Insurance insurance;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    @ToString.Exclude
    private List<Appointment> appointments = new ArrayList<>();

    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
        appointment.setPatient(this);
    }

    public void removeAppointment(Appointment appointment){
        appointments.remove(appointment);
        appointment.setPatient(null);
    }
}
