package com.tomasz.vet.domain.entities;

import com.tomasz.vet.domain.compositekeys.DiagnosisKey;
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
@Table(name="diagnoses")
public class DiagnosisEntity {
    @EmbeddedId
    private DiagnosisKey id;

    @ManyToOne
    @MapsId("appointmentId")
    @JoinColumn(name = "appointment_id")
    private AppointmentEntity appointment;

    @ManyToOne
    @MapsId("illnessId")
    @JoinColumn(name="illness_id")
    private IllnessEntity illness;

    private String recoveryStatus;
}
