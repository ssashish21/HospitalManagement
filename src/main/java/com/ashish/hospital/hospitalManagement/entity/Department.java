package com.ashish.hospital.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private String name;

    @OneToOne
    private Doctor headDoctor;

    @ManyToMany
    @ToString.Exclude
//    @JoinTable(
//            name = "doc_dpt",
//            joinColumns = @JoinColumn(name = "dpt_id"),
//            inverseJoinColumns = @JoinColumn(name = "doc_id")
//    )
    private Set<Doctor> doctors = new HashSet<>();
}
