package com.ashish.hospital.hospitalManagement.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    @JsonIgnore
    private List<Appointment> appointments;

    @ManyToMany(mappedBy = "doctors")
    @ToString.Exclude
    private Set<Department> departments;

    public void addAppointment(Appointment appointment){
        appointments.add(appointment);
        appointment.setDoctor(this);
    }

    public void removeAppointment(Appointment appointment){
        appointments.remove(appointment);
        appointment.setDoctor(null);
    }
}
