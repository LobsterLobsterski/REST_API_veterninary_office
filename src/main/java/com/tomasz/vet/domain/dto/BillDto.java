package com.tomasz.vet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BillDto {

    private Long id;
    private Date issueDate;

    private AppointmentDto appointment;
    private Set<ProcedureDto> proceduresBilled = new HashSet<>();
    public float getPrice(){
        System.out.println(proceduresBilled);
        return 0;
    }
}
