package com.tomasz.vet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="prescriptions")
public class PrescriptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_id_seq")
    private Long id;

    private Date issueDate;

    @OneToOne
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;

    @OneToMany(mappedBy = "prescription")
    Set<MedicinePrescriptionEntity> dosages;


}
