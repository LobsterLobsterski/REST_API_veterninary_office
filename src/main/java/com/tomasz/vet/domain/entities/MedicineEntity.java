package com.tomasz.vet.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="medicines")
public class MedicineEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_id_seq")
    private Long id;

    private String name;
    private String producerName;

    @OneToMany
    @JoinColumn(name="medicine")
    private Set<MedicinePrescriptionEntity> dosages;
}
