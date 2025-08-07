package com.ashish.hospital.hospitalManagement.entity;

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
    private List<Appointment> appointments;

    @ManyToMany(mappedBy = "doctors")
    @ToString.Exclude
    private Set<Department> departments;

}
