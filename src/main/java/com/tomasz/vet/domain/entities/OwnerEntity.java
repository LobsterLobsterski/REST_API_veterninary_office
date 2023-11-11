package com.tomasz.vet.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="owners")
public class OwnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="owner_id")
    private Long id;
    private String phoneNumber;
    private String name;
    private String surname;
    private String cardNumber;

}
