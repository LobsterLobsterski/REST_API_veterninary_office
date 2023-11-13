package com.tomasz.vet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasz.vet.TestDataUtil;
import com.tomasz.vet.domain.entities.ProcedureEntity;
import com.tomasz.vet.services.ProcedureService;
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
public class ProcedureControllerIntegrationTests {
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final ProcedureService procedureService;

    @Autowired
    public ProcedureControllerIntegrationTests(MockMvc mockMvc, ProcedureService procedureService) {
        this.mockMvc = mockMvc;
        this.objectMapper = new ObjectMapper();
        this.procedureService = procedureService;
    }

    @Test
    public void testThatCreateProcedureReturnsHttp201() throws Exception {
        ProcedureEntity procedureA = TestDataUtil.createProcedureA(null);
        String json = objectMapper.writeValueAsString(procedureA);

        mockMvc.perform(MockMvcRequestBuilders.post("/procedure")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateProcedureReturnsCreatedProcedure() throws Exception {
        ProcedureEntity procedureA = TestDataUtil.createProcedureA(null);
        String json = objectMapper.writeValueAsString(procedureA);

        mockMvc.perform(MockMvcRequestBuilders.post("/procedure")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.name").value(procedureA.getName())
        ).andExpect(MockMvcResultMatchers.jsonPath("$.cost").value(procedureA.getCost())
        ).andExpect(MockMvcResultMatchers.jsonPath("$.comments").value(procedureA.getComments())
        ).andExpect(MockMvcResultMatchers.jsonPath("$.onBills").value(procedureA.getOnBills())

        );
    }
}
