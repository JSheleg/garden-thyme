package com.company.plantinventoryservice.controller;

import com.company.plantinventoryservice.dto.Note;
import com.company.plantinventoryservice.repository.NoteRepository;
import com.company.plantinventoryservice.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class NoteController {

    @Autowired
    PlantRepository plantRepository;

    @Autowired
    NoteRepository noteRepository;

    @PostMapping("/note")
    public void addNote(@RequestBody @Valid Note note){

        noteRepository.save(note);
    }

    @DeleteMapping("/note/{id}")
    public void deleteNote(@PathVariable int id){
        noteRepository.deleteById(id);
    }


}
