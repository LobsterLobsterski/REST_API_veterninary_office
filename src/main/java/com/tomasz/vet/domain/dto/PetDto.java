package com.tomasz.vet.domain.dto;

import com.tomasz.vet.domain.entities.OwnerEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetDto {
    private Long id;

    private String name;
    private String birthDate;
    private Boolean isMale;
    private String chipNr;
    private String race;

    private OwnerDto owner;
}
