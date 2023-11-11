package com.tomasz.vet.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentDto {

    private long id;
    private Date registrationDate;
    private Date appointmentDate;
    private PetDto pet;
    private VeterinarianDto veterinarian;
}
