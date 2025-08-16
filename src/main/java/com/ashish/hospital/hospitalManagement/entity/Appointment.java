package com.ashish.hospital.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_doctor_appointment_time", columnNames = {"doctor_id", "appointment_time"})
        },
        indexes = {
                @Index(name = "idx_appointment_time", columnList = "appointment_time"),
                @Index(name = "idx_doctor", columnList = "doctor_id"),
                @Index(name = "idx_doctor_appointment_time", columnList = "doctor_id, appointment_time")
        }
)
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false) // patient is required and not nullable
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
}
