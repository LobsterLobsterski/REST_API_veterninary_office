package com.tomasz.vet.dto;

import com.tomasz.vet.entities.Pet;
import com.tomasz.vet.entities.Veterinarian;
import jakarta.persistence.*;
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
    private Pet pet;
    private Veterinarian veterinarian;
}
