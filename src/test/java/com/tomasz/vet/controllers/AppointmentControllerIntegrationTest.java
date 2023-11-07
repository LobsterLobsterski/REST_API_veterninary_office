package com.tomasz.vet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasz.vet.TestDataUtil;
import com.tomasz.vet.entities.Appointment;
import com.tomasz.vet.entities.Pet;
import com.tomasz.vet.entities.PetOwner;
import com.tomasz.vet.entities.Veterinarian;
import com.tomasz.vet.services.AppointmentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class AppointmentControllerIntegrationTest {

    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;
    private final AppointmentService appointmentService;

    @Autowired
    public AppointmentControllerIntegrationTest(MockMvc mockMvc, AppointmentService appointmentService) {
        this.mockMvc = mockMvc;
        this.appointmentService = appointmentService;
        this.objectMapper = new ObjectMapper();

    }

    @Test
    public void testThatCreateAppointmentReturnsHttpCreatedWhenCreated() throws Exception {
        PetOwner ownerA = TestDataUtil.createOwnerA();
        Pet petA = TestDataUtil.createPetA(ownerA);
        Veterinarian vetA = TestDataUtil.createVetA();
        Appointment appointmentA = TestDataUtil.createAppointmentA(petA, vetA);

        String appointmentJson = objectMapper.writeValueAsString(appointmentA);

        System.out.println(appointmentJson);

        mockMvc.perform(MockMvcRequestBuilders.post("/appointment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(appointmentJson)
        ).andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber()
                //add the rest
        );

    }

}
