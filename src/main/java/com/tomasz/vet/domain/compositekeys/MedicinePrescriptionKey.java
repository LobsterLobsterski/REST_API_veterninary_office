package com.tomasz.vet.domain.compositekeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class MedicinePrescriptionKey implements Serializable {
    @Column(name = "prescription_id")
    Long prescriptionId;

    @Column(name="medicine_id")
    Long medicineId;
}
