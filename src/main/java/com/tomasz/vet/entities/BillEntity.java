package com.tomasz.vet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="bills")
public class BillEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bill_id_seq")
    @Column(name="bill_id")
    private Long id;
    private Date issueDate;

    @OneToOne
    @JoinColumn(name="appointment_id")
    private AppointmentEntity appointment;

    @ManyToMany
    @JoinTable(name="bill_procedure",
            joinColumns= {
                @JoinColumn(name = "bill_id")
            },
            inverseJoinColumns={
                @JoinColumn(name="procedure_id")
            }
    )
    private Set<ProcedureEntity> proceduresBilled = new HashSet<>();

    public float getPrice(){
        System.out.println(proceduresBilled);
        return 0;
    }

}
