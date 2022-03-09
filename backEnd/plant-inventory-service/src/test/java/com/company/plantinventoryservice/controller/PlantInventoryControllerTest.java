package com.company.plantinventoryservice.controller;

import com.company.plantinventoryservice.dto.Plant;
import com.company.plantinventoryservice.repository.NoteRepository;
import com.company.plantinventoryservice.repository.PlantRepository;
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

import java.util.Optional;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(PlantInventoryController.class)
public class PlantInventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    PlantRepository plantRepository;

    @MockBean
    NoteRepository noteRepository;

    private ObjectMapper mapper = new ObjectMapper();

    Plant inputOrange;
    Plant outputOrange;
    Plant inputOak;
    Plant outputOak;

    @Before
    public void setUp() throws Exception {
        inputOrange = new Plant("Val", "Valencia Orange", "SomeFancyName", "Full Sun", "2/month", 12);
        outputOrange = new Plant("Val", "Valencia Orange", "SomeFancyName", "Full Sun", "2/month", 12);
        outputOrange.setId(1);
        inputOak = new Plant("Carl", "Oak Tree", "some old name", "Full Sun", "2/month", 12);
        outputOak = new Plant("Carl", "Oak Tree", "some old name", "Full Sun", "2/month", 12);
        outputOak.setId(2);

        doReturn(outputOrange).when(plantRepository).save(inputOrange);
        doReturn(Optional.of(outputOrange)).when(plantRepository).findById(1);
        doReturn(outputOak).when(plantRepository).save(outputOak);
        doReturn(Optional.of(outputOak)).when(plantRepository).findById(2);
    }

    @Test
    public void shouldAddPlantOnPostRequest() throws Exception{
        String inputJson = mapper.writeValueAsString(inputOrange);
        String outputJson = mapper.writeValueAsString(outputOrange);

        mockMvc.perform(post("/plant")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void shouldGetPlantById() throws Exception {
        String outputJson = mapper.writeValueAsString(outputOrange);

        mockMvc.perform(get("/plant/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));

    }


//    @Test
//    public void shouldReturn422StatusCodeWithInvalidRequestBody() throws Exception{
//        Plant inputPlant = new Plant();
//        inputPlant.setPlantName("Valencia Orange");
////        inputPlant.setNickname("val");
//        inputPlant.setScientificName("Some fancy name");
//        inputPlant.setSunlightHours("Full Sun");
//        inputPlant.setWaterFrequency("2 / week");
//
//        String inputJSon = mapper.writeValueAsString(inputPlant);
//
//        mockMvc.perform(
//                post("/plant")
//                        .content(inputJSon)
//                        .contentType(MediaType.APPLICATION_JSON)
//        )
//                .andDo(print())
//                .andExpect(status().isUnprocessableEntity());
//
//    }




}