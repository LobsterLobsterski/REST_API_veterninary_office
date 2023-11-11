package com.tomasz.vet.domain.dto;

import com.tomasz.vet.domain.compositekeys.MedicinePrescriptionKey;
import com.tomasz.vet.domain.entities.MedicineEntity;
import com.tomasz.vet.domain.entities.PrescriptionEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicinePrescriptionDto {

    MedicinePrescriptionKey id;
    MedicineDto medicine;
    PrescriptionDto prescription;
    int dosage;
}
