package com.tomasz.vet.entities;

import com.tomasz.vet.entities.compositekeys.MedicinePrescriptionKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="medicine_prescriptions")
public class MedicinePrescriptionEntity {

    @EmbeddedId
    MedicinePrescriptionKey id;

    @ManyToOne
    @MapsId("medicineId")
    @JoinColumn(name="medicine_id")
    MedicineEntity medicine;

    @ManyToOne
    @MapsId("prescriptionId")
    @JoinColumn(name="prescription_id")
    PrescriptionEntity prescription;

    int dosage;
}
