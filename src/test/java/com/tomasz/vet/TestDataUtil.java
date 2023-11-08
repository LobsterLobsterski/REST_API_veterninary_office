package com.tomasz.vet;

import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.entities.Pet;
import com.tomasz.vet.entities.PetOwner;
import com.tomasz.vet.entities.Veterinarian;

import java.util.Date;

public class TestDataUtil {

    public static Appointment createAppointmentA(Pet pet, Veterinarian vet){
        return Appointment.builder()
                .id(23L)
                .appointmentDate(new Date(2023-1900, 11, 23))
                .registrationDate(new Date(2023-1900, 7, 10))
                .pet(pet)
                .veterinarian(vet)
                .build();
    }

    public static Pet createPetA(PetOwner owner){
        return Pet.builder()
                .id(1L)
                .name("Fluffy")
                .birthDate("2020-6-11")
                .isMale(true)
                .chipNr("123abc")
                .race("Pomeranian")
                .owner(owner)
                .build();

    }

    public static PetOwner createOwnerA(){
        return PetOwner.builder()
                .id(1L)
                .phoneNumber("123123123")
                .name("John")
                .surname("Doe")
                .cardNumber("9999999")
                .build();
    }

    public static Veterinarian createVetA(){
        return Veterinarian.builder()
                .id(1L)
                .name("Alex")
                .surname("Jones")
                .position("Head Veterinarian")
                .build();
    }
}
