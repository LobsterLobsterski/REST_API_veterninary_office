package com.tomasz.vet.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomasz.vet.TestDataUtil;
import com.tomasz.vet.domain.entities.BillEntity;
import com.tomasz.vet.domain.entities.ProcedureEntity;
import com.tomasz.vet.services.BillService;
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

import java.util.HashSet;
import java.util.Set;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class BillControllerIntegrationTests {

    private final ObjectMapper objectMapper;
    private final MockMvc mockMvc;
    private final BillService billService;

    @Autowired
    public BillControllerIntegrationTests(MockMvc mockMvc, BillService billService) {
        this.objectMapper = new ObjectMapper();
        this.mockMvc = mockMvc;
        this.billService = billService;
    }

    @Test
    public void testThatCreateBillReturnsHttp201() throws Exception {
        BillEntity billA = TestDataUtil.createBillA(null, null);
        String json = objectMapper.writeValueAsString(billA);

        mockMvc.perform(MockMvcRequestBuilders.post("/bills")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.status().isCreated()
        );
    }

    @Test
    public void testThatCreateBillReturnsCreatedBill() throws Exception {
        BillEntity billA = TestDataUtil.createBillA(null, null);
        String json = objectMapper.writeValueAsString(billA);

        mockMvc.perform(MockMvcRequestBuilders.post("/bills")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        ).andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.issueDate").value(billA.getIssueDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(MockMvcResultMatchers.jsonPath("$.appointment").value(billA.getAppointment())
        ).andExpect(MockMvcResultMatchers.jsonPath("$.proceduresBilled").value(billA.getProceduresBilled())
        );
    }

    @Test
    public void testThatFindOneBillReturnsHttp200WhenExists() throws Exception {
        BillEntity billA = TestDataUtil.createBillA(null, null);
        BillEntity saved = billService.create(billA);

        mockMvc.perform(MockMvcRequestBuilders.get("/bills/"+saved.getId())
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk()
        );
    }

    @Test
    public void testThatFindOneBillReturnsHttp404WhenDoesntExists() throws Exception {
        BillEntity billA = TestDataUtil.createBillA(null, null);
//        BillEntity saved = billService.create(billA);

        mockMvc.perform(MockMvcRequestBuilders.get("/bills/1")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isNotFound()
        );
    }

    @Test
    public void testThatFindOneBillReturnsFoundBill() throws Exception {
        BillEntity billA = TestDataUtil.createBillA(null, null);
        BillEntity saved = billService.create(billA);

        mockMvc.perform(MockMvcRequestBuilders.get("/bills/"+saved.getId())
                .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.jsonPath("$.id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.issueDate").value(billA.getIssueDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(MockMvcResultMatchers.jsonPath("$.appointment").value(billA.getAppointment())
        ).andExpect(MockMvcResultMatchers.jsonPath("$.proceduresBilled").isArray()
        );
    }

    @Test
    public void testThatFindAllBillsReturnsAPageOfBills() throws Exception {
        BillEntity billA = TestDataUtil.createBillA(null, null);
        BillEntity saved = billService.create(billA);

        mockMvc.perform(MockMvcRequestBuilders.get("/bills")
                .contentType(MediaType.APPLICATION_JSON)

        ).andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").isNumber()
        ).andExpect(MockMvcResultMatchers.jsonPath("$.content[0].issueDate").value(billA.getIssueDate().toInstant().toString().substring(0, 19)+".000+00:00")
        ).andExpect(MockMvcResultMatchers.jsonPath("$.content[0].appointment").value(billA.getAppointment())
        ).andExpect(MockMvcResultMatchers.jsonPath("$.content[0].proceduresBilled").isArray()
        );
    }


}
