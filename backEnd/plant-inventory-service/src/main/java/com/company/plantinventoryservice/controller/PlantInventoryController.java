package com.company.plantinventoryservice.controller;

import com.company.plantinventoryservice.dto.Note;
import com.company.plantinventoryservice.dto.Plant;
import com.company.plantinventoryservice.repository.NoteRepository;
import com.company.plantinventoryservice.repository.PlantRepository;
import com.company.plantinventoryservice.util.feign.GrowZoneClient;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@RestController
@RefreshScope
public class PlantInventoryController {

    @Autowired
    PlantRepository plantRepository;
    @Autowired
    NoteRepository noteRepository;
    @Autowired
    private final GrowZoneClient client;

    PlantInventoryController(GrowZoneClient client){
        this.client = client;
    }


    @PostMapping("/plant")
    public Plant createPlant(@RequestBody Plant plant){
        plantRepository.save(plant);
        return plant;
    }

    @GetMapping("/plant")
    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }

    @GetMapping("/zone")
    public String getAllZones() {
        return client.getAllZones();
    }

    @GetMapping("/plant/{id}")
    public Plant getPlants(@PathVariable int id){
        Optional<Plant> plant = plantRepository.findById(id);

        if(!plant.isPresent()){
            throw new IllegalArgumentException("Plant doesn't exist");
        }
        return plant.get();
    }

    @PutMapping("/plant/{id}")
    public void updatePlant(@RequestBody Plant plant, @PathVariable int id){
        if(plant.getId() == null){
            plant.setId(id);
        }
        if(plant.getId()!=id){
            throw new IllegalArgumentException("Plant Id must match parameter given");
        }
        plantRepository.save(plant);
    }

    @DeleteMapping("/plant/{id}")
    public void deletePlant(@PathVariable int id){
        plantRepository.deleteById(id);
    }


}
