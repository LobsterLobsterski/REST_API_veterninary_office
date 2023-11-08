package com.tomasz.vet.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="veterinarians")
public class VeterinarianEntity {
    @Id
    @Column(name = "vet_id")
    private Long id;
    private String name;
    private String surname;
    private String position;
}
