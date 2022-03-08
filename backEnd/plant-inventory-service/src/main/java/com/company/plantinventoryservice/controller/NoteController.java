//package com.company.plantinventoryservice.controller;
//
//import com.company.plantinventoryservice.dto.Note;
//import com.company.plantinventoryservice.dto.Plant;
//import com.company.plantinventoryservice.repository.NoteRepository;
//import com.company.plantinventoryservice.repository.PlantRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//public class NoteController {
//    @Autowired
//    PlantRepository plantRepository;
//    @Autowired
//    NoteRepository noteRepository;
//
//    //add note to plant
//    @PostMapping("/plant/{id}")
//    public Plant addNoteToPlant(@RequestBody Note note, @PathVariable int id){
//        if(note.getId() == null){
//            note.setId(id);
//        }
//        if(note.getId()!=id){
//            throw new IllegalArgumentException("Note Id must match parameter given");
//        }
//        noteRepository.save(note);
//        Optional<Plant> plant = plantRepository.getById(id).setNotes(note);
//    }
//}
