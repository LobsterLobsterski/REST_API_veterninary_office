package com.tomasz.vet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasz.vet.TestDataUtil;
import com.tomasz.vet.entities.AppointmentEntity;
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
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
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
    public void testThatCreatingAppointmentReturnsHttp201() throws Exception {
        AppointmentEntity appointment = TestDataUtil.createAppointmentA(null, null);
        String json = objectMapper.writeValueAsString(appointment);

        mockMvc.perform(MockMvcRequestBuilders.post("/appointment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isCreated()
        ).andDo(MockMvcResultHandlers.print()
        );
    }

    @Test
    public void testThatCreatingAppointmentReturnsCreatedAppointment() throws Exception {
        AppointmentEntity appointment = TestDataUtil.createAppointmentA(null, null);
        String json = objectMapper.writeValueAsString(appointment);

        mockMvc.perform(
                MockMvcRequestBuilders.post("/appointment")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.registrationDate").value(appointment.getRegistrationDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.appointmentDate").value(appointment.getAppointmentDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.pet").value(appointment.getPet())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.veterinarian").value(appointment.getVeterinarian())
        );
    }

    @Test
    public void testThatFindOneAppointmentReturnsHttp200WhenExists() throws Exception {
        AppointmentEntity appointment = TestDataUtil.createAppointmentA(null, null);
        appointmentService.create(appointment);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointment/"+appointment.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatFindOneAppointmentReturnsHttp404WhenDoesntExists() throws Exception {
        AppointmentEntity appointment = TestDataUtil.createAppointmentA(null, null);
        //appointmentService.create(appointment);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointment/"+appointment.getId())
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatFindOneAppointmentReturnsCorrectAppointment() throws Exception {
        AppointmentEntity appointment = TestDataUtil.createAppointmentA(null, null);
        AppointmentEntity saved = appointmentService.create(appointment);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointment/"+saved.getId())
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.id").value(saved.getId())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.registrationDate").value(saved.getRegistrationDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.appointmentDate").value(saved.getAppointmentDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.pet").value(saved.getPet())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.veterinarian").value(saved.getVeterinarian())
        );

    }

    @Test
    public void testThatFindAllReturnsAPageOfExistingAppointments() throws Exception {
        AppointmentEntity appointment = TestDataUtil.createAppointmentA(null, null);
        AppointmentEntity saved = appointmentService.create(appointment);

        mockMvc.perform(
                MockMvcRequestBuilders.get("/appointment")
                        .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.content[0].id").value(saved.getId())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.content[0].registrationDate").value(saved.getRegistrationDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.content[0].appointmentDate").value(saved.getAppointmentDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.content[0].pet").value(saved.getPet())
        ).andExpect(
                MockMvcResultMatchers.jsonPath("$.content[0].veterinarian").value(saved.getVeterinarian())
        );

    }


}
