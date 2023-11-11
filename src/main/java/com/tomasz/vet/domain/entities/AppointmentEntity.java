package com.tomasz.vet.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "appointments")
public class AppointmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_id_seq")
    @Column(name="appointment_id")
    private Long id;

    private Date registrationDate;
    private Date appointmentDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pet_id")
    private PetEntity pet;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="vet_id")
    private VeterinarianEntity veterinarian;

    @OneToMany(mappedBy = "appointment")
    Set<DiagnosisEntity> diagnoses;
}
