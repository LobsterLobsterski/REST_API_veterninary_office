package com.tomasz.vet.domain.compositekeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DiagnosisKey implements Serializable {
    @Column(name = "appointment_id")
    Long appointmentId;

    @Column(name="illness_id")
    String illnessId;
}
