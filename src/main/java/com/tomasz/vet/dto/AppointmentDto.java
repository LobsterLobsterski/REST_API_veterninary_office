package com.tomasz.vet.dto;

import com.tomasz.vet.entities.PetEntity;
import com.tomasz.vet.entities.VeterinarianEntity;
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
    private PetEntity pet;
    private VeterinarianEntity veterinarian;
}
