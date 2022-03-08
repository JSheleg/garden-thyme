package com.company.plantinventoryservice.dto;

import com.company.plantinventoryservice.repository.NoteRepository;
import com.company.plantinventoryservice.repository.PlantRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NoteTest {

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    NoteRepository noteRepo;

    @Test
    public void contextLoads(){
    }

    @Test
    public void createTest(){
        noteRepo.deleteAll();
        plantRepository.deleteAll();

        Plant plant1 = new Plant();
        plant1.setPlantName("Valencia Orange");
        plant1.setNickname("Val");
        plant1.setScientificName("some fancy name");
        plant1.setSunlightHours("Full Sun");
        plant1.setWaterFrequency("2x week");
        plant1.setZoneId(12);

        Note note = new Note();
        note.setContent("Val was replanted on 2/22/22");
        Set noteSet = new HashSet<>();
        noteSet.add(note);

        Note note2 = new Note();
        note.setContent("Val had 3 fertilizer sticks on 2/22/22, add more fertilizer in 12 weeks");
        noteSet.add(note2);


        plantRepository.save(plant1);

        note.setPlantId(plant1.getId());
        note2.setPlantId(plant1.getId());

        noteRepo.save(note);
        noteRepo.save(note2);

        List<Plant> plantList = plantRepository.findAll();
        assertEquals(1, plantList.size());

        noteSet = plantList.get(0).getNotes();
        assertEquals(2, noteSet.size());

    }



}