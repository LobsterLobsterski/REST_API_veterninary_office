package com.tomasz.vet.domain.dto;

import com.tomasz.vet.domain.entities.AppointmentEntity;
import com.tomasz.vet.domain.entities.MedicinePrescriptionEntity;
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
public class PrescriptionDto {
    private Long id;

    private Date issueDate;

    private AppointmentDto appointment;

    Set<MedicinePrescriptionDto> dosages;
}
