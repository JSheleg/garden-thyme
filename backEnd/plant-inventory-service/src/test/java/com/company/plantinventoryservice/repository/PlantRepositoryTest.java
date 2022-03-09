package com.company.plantinventoryservice.repository;

import com.company.plantinventoryservice.dto.Note;
import com.company.plantinventoryservice.dto.Plant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.text.html.Option;
import java.util.*;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PlantRepositoryTest {

    @Autowired
    NoteRepository noteRepository;
    @Autowired
    PlantRepository plantRepository;

    @Before
    public void setUp() throws Exception {

        noteRepository.deleteAll();
        plantRepository.deleteAll();
    }

    @Test
    public void addGetDeletePlant(){
        //create plant
        Plant plant = new Plant();
        plant.setPlantName("Valencia Orange");
        plant.setNickname("Val");
        plant.setScientificName("some fancy name");
        plant.setSunlightHours("Full Sun");
        plant.setWaterFrequency("2x week");
        plant.setZoneId(12);
        plant = plantRepository.save(plant);

        //create a second plant

        plant = new Plant();
        plant.setPlantName("White Oak");
        plant.setNickname("Carl");
        plant.setScientificName("fancy name");
        plant.setSunlightHours("Full Sun");
        plant.setWaterFrequency("1x week");
        plant.setZoneId(10);
        plant = plantRepository.save(plant);

        List<Plant> plist = plantRepository.findAll();
        assertEquals(plist.size(),2);
    }

    @Test
    public void updatePlant(){

        Plant plant = new Plant();
        plant.setPlantName("Valencia Orange");
        plant.setNickname("Val");
        plant.setScientificName("some fancy name");
        plant.setSunlightHours("Full Sun");
        plant.setWaterFrequency("2x week");
        plant.setZoneId(12);
        plant = plantRepository.save(plant);

        //create notes
        Note note = new Note();
        note.setContent("Val was replanted on 2/22/22");
        note.setPlantId(plant.getId());
        note = noteRepository.save(note);

        Set<Note> notes = new HashSet<>();
        notes.add(note);
        plant.setNotes(notes);
        plant = plantRepository.save(plant);


        plant.setNickname("Val is Victor Now");
        plant.setZoneId(10);
        plant.setSunlightHours("Partial Shade");
        plant = plantRepository.save(plant);
        System.out.println(plant);

        Optional<Plant> plant1 = plantRepository.findById(plant.getId());
        System.out.println(plant1);
        assertEquals(plant1.get(), plant);

//        Expected :Plant{id=1, nickname='Val is Victor Now', plantName='Valencia Orange', scientificName='some fancy name', sunlightHours='Partial Shade', waterFrequency='2x week', zoneId=10, notes=[]}
//        Actual   :Plant{id=1, nickname='Val is Victor Now', plantName='Valencia Orange', scientificName='some fancy name', sunlightHours='Partial Shade', waterFrequency='2x week', zoneId=10, notes=null}
    }


}