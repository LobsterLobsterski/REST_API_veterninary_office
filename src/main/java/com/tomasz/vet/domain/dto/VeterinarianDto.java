package com.tomasz.vet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VeterinarianDto {
    private Long id;
    private String name;
    private String surname;
    private String position;
}
