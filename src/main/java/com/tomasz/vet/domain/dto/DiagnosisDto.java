package com.tomasz.vet.domain.dto;

import com.tomasz.vet.domain.compositekeys.DiagnosisKey;
import com.tomasz.vet.domain.entities.AppointmentEntity;
import com.tomasz.vet.domain.entities.IllnessEntity;
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
public class DiagnosisDto {
    private DiagnosisKey id;
    private AppointmentDto appointment;
    private IllnessDto illness;
    private String recoveryStatus;
}
