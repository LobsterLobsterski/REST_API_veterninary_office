package com.tomasz.vet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="pets")
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="pet_id")
    private Long id;

    private String name;
    private String birthDate;
    private Boolean isMale;
    private String chipNr;
    private String race;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private PetOwner owner;

}
