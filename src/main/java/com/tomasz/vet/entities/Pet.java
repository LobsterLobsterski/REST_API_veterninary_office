package com.tomasz.vet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="pet_id")
    private Long id;

    private String name;
    private Date birthDate;
    private Boolean isMale;
    private String chip_nr;
    private String race;

    @ManyToOne(optional = false)
    @JoinColumn(name = "owner_id")
    private PetOwner owner;

    @OneToMany
    @JoinColumn(name="appointment_id")
    private Appointment appointment;

}
