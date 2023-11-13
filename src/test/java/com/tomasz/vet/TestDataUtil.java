package com.tomasz.vet;

import com.tomasz.vet.domain.entities.*;

import java.util.Date;
import java.util.Set;

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

    public static BillEntity createBillA(AppointmentEntity appointment, Set<ProcedureEntity> procedures){
        return BillEntity.builder()
                .id(1L)
                .issueDate(new Date(2023-1900, 11, 23))
                .appointment(appointment)
                .proceduresBilled(procedures)
                .build();
    }

    public static BillEntity createBillB(AppointmentEntity appointment, Set<ProcedureEntity> procedures){
        return BillEntity.builder()
                .id(23L)
                .issueDate(new Date(2020-1900, 12, 13))
                .appointment(appointment)
                .proceduresBilled(procedures)
                .build();
    }

    public static ProcedureEntity createProcedureA(Set<BillEntity> onBills){
        return ProcedureEntity.builder()
                .id(1L)
                .name("Neutering")
                .cost(120)
                .comments(null)
                .onBills(onBills)
                .build();
    }

    public static ProcedureEntity createProcedureB(Set<BillEntity> onBills){
        return ProcedureEntity.builder()
                .id(2L)
                .name("flea removal")
                .cost(30)
                .comments("use new product")
                .onBills(onBills)
                .build();
    }
}
