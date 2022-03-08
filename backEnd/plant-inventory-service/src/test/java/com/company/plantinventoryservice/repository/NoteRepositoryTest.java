package com.company.plantinventoryservice.repository;

import com.company.plantinventoryservice.dto.Note;
import com.company.plantinventoryservice.dto.Plant;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class NoteRepositoryTest {
    @Autowired
    PlantRepository plantRepository;

    @Autowired
    NoteRepository noteRepository;

    @Before
    public void setUp() throws Exception {

        noteRepository.deleteAll();
        plantRepository.deleteAll();
    }

    @Test
    public void addGetDeleteNote(){
        //create plant
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

        Optional<Note> note1 = noteRepository.findById(note.getId());
        assertEquals(note1.get(), note);

        noteRepository.deleteById(note.getId());
        note1 = noteRepository.findById(note.getId());
        assertFalse(note1.isPresent());
    }

    @Test
    public void updateNote(){
        //create plant
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

        note.setContent("Val was replanted on 2/25/22, please update records to ensure 12 weeks before next fertilizer is added");
        noteRepository.save(note);

        Optional<Note> note1 = noteRepository.findById(note.getId());
        assertEquals(note1.get(), note);
    }

    @Test
    public void getAllNotes(){
        //create plant
        Plant plant = new Plant();
        plant.setPlantName("Valencia Orange");
        plant.setNickname("Val");
        plant.setScientificName("some fancy name");
        plant.setSunlightHours("Full Sun");
        plant.setWaterFrequency("2x week");
        plant.setZoneId(12);
        plant = plantRepository.save(plant);

        Plant plant1 = new Plant();
        plant1.setPlantName("White Oak");
        plant1.setNickname("Carl");
        plant1.setScientificName("fancy name");
        plant1.setSunlightHours("Full Sun");
        plant1.setWaterFrequency("1x week");
        plant1.setZoneId(10);
        plant1 = plantRepository.save(plant1);

        Note note = new Note();
        note.setContent("Val was replanted on 2/22/22");
        note.setPlantId(plant.getId());
        note = noteRepository.save(note);

        note = new Note();
        note.setContent("Carl had 3 fertilizer sticks on 2/22/22, add more fertilizer in 12 weeks");
        note.setId(plant1.getId());
        note = noteRepository.save(note);

        List<Note> noteList = noteRepository.findAll();
        assertEquals(noteList.size(),2);
    }

    @Test
    public void getAllNotesByPlant(){
        //create plant
        Plant plant = new Plant();
        plant.setPlantName("Valencia Orange");
        plant.setNickname("Val");
        plant.setScientificName("some fancy name");
        plant.setSunlightHours("Full Sun");
        plant.setWaterFrequency("2x week");
        plant.setZoneId(12);
        plant = plantRepository.save(plant);

        Plant plant1 = new Plant();
        plant1.setPlantName("White Oak");
        plant1.setNickname("Carl");
        plant1.setScientificName("fancy name");
        plant1.setSunlightHours("Full Sun");
        plant1.setWaterFrequency("1x week");
        plant1.setZoneId(10);
        plant1 = plantRepository.save(plant1);

        Note note = new Note();
        note.setContent("Val was replanted on 2/22/22");
        note.setPlantId(plant.getId());
        note = noteRepository.save(note);

        note = new Note();
        note.setContent("Carl had 3 fertilizer sticks on 2/22/22, add more fertilizer in 12 weeks");
        note.setPlantId(plant1.getId());
        note = noteRepository.save(note);

        note = new Note();
        note.setContent("Carl was planted in October 2020");
        note.setPlantId(plant1.getId());
        note = noteRepository.save(note);

        List<Note>noteList = noteRepository.findAllNotesByPlantId(plant.getId());
        assertEquals(noteList.size(), 1);

        noteList = noteRepository.findAllNotesByPlantId(plant1.getId());
        assertEquals(noteList.size(),2);

    }

}