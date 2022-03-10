package com.company.growzoneservice.controller;

import com.company.growzoneservice.dto.GrowZone;
import com.company.growzoneservice.repository.GrowZoneRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.doReturn;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(GrowZoneController.class)
public class GrowZoneControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    GrowZoneRepository zoneRepo;

    private ObjectMapper mapper = new ObjectMapper();

    GrowZone inputZone1;
    GrowZone outputZone1;

    GrowZone inputZone2;
    GrowZone outputZone2;

    List<GrowZone> zoneList;

    @Before
    public void setUp() throws Exception {
        inputZone1 = new GrowZone(5,-20,-10);
        outputZone1 = new GrowZone(5,-20,-10);

        inputZone2 = new GrowZone(7,5,10);
        outputZone2 = new GrowZone(7,5,10);

        zoneList = new ArrayList<>(Arrays.asList(
                outputZone1,
                outputZone2
        ));

        doReturn(outputZone1).when(zoneRepo).save(inputZone1);
        doReturn(Optional.of(outputZone1)).when(zoneRepo).findById(5);
        doReturn(zoneList).when(zoneRepo).findAll();
    }

    @Test
    public void shouldAddAndGetZone() throws Exception{
        String inputJson = mapper.writeValueAsString(inputZone1);
        String  outputJson = mapper.writeValueAsString(outputZone1);

        mockMvc.perform(post("/zone")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetCustomerById() throws Exception {
        String  outputJson = mapper.writeValueAsString(outputZone1);

        mockMvc.perform(get("/zone/5"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldRespondWith204WhenUpdatingCustomer() throws Exception {
        inputZone1.setZoneId(5);
        inputZone1.setLowTemp(-37);

        String inputJson = mapper.writeValueAsString(inputZone1);

        mockMvc.perform(put("/zone/5")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    public void shouldRespondWith204WhenDeletingZone() throws Exception {
        mockMvc.perform(delete("/zone/5"))
                .andExpect(status().isNoContent());
    }

}