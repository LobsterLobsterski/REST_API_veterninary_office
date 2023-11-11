package com.tomasz.vet.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="illnesses")
public class IllnessEntity {
    @Id
    @Column(name="illness_id")
    private String name;

    private List<String> symptoms;

    @OneToMany(mappedBy = "illness")
    Set<DiagnosisEntity> diagnoses;


}
