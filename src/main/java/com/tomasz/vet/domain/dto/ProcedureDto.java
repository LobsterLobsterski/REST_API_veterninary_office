package com.tomasz.vet.domain.dto;

import com.tomasz.vet.domain.entities.BillEntity;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProcedureDto {
    private Long id;

    private String name;
    private Float cost;
    private String comments;

    private Set<BillDto> onBills = new HashSet<>();
}
