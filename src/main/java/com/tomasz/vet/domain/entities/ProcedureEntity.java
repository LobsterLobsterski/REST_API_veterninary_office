package com.tomasz.vet.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name="procedures")
public class ProcedureEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "procedure_id_seq")
    @Column(name="procedure_id")
    private Long id;

    private String name;
    private float cost;
    private String comments;

    @ManyToMany(mappedBy = "proceduresBilled")
    private Set<BillEntity> onBills = new HashSet<>();
}
