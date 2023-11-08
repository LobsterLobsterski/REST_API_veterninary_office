package com.tomasz.vet;

import com.tomasz.vet.entities.AppointmentEntity;
import com.tomasz.vet.entities.PetEntity;
import com.tomasz.vet.entities.OwnerEntity;
import com.tomasz.vet.entities.VeterinarianEntity;

import java.util.Date;

public class TestDataUtil {

    public static AppointmentEntity createAppointmentA(PetEntity pet, VeterinarianEntity vet){
        return AppointmentEntity.builder()
                .id(23L)
                .appointmentDate(new Date(2023-1900, 11, 23))
                .registrationDate(new Date(2023-1900, 7, 10))
                .pet(pet)
                .veterinarian(vet)
                .build();
    }

    public static PetEntity createPetA(OwnerEntity owner){
        return PetEntity.builder()
                .id(1L)
                .name("Fluffy")
                .birthDate("2020-6-11")
                .isMale(true)
                .chipNr("123abc")
                .race("Pomeranian")
                .owner(owner)
                .build();

    }

    public static OwnerEntity createOwnerA(){
        return OwnerEntity.builder()
                .id(1L)
                .phoneNumber("123123123")
                .name("John")
                .surname("Doe")
                .cardNumber("9999999")
                .build();
    }

    public static VeterinarianEntity createVetA(){
        return VeterinarianEntity.builder()
                .id(1L)
                .name("Alex")
                .surname("Jones")
                .position("Head Veterinarian")
                .build();
    }
}
