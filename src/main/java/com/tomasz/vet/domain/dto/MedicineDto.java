package com.tomasz.vet.domain.dto;

import com.tomasz.vet.domain.entities.MedicinePrescriptionEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MedicineDto {
    private Long id;

    private String name;
    private String producerName;

    private Set<MedicinePrescriptionDto> dosages;
}
