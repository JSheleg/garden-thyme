package com.company.plantinventoryservice.controller;

import com.company.plantinventoryservice.dto.Plant;
import com.company.plantinventoryservice.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
//@RefreshScope
public class PlantInventoryController {
    @Autowired
    private PlantRepository plantRepository;

    @PostMapping
    public Plant createPlant(@RequestBody Plant plant){
        plantRepository.save(plant);
        return plant;
    }

    @GetMapping("/plant")
    public List<Plant> getAllPlants(){
        return plantRepository.findAll();
    }

    @GetMapping("/plants/{id}")
    public Plant getPlants(@PathVariable int id){
        Optional<Plant> plant = plantRepository.findById(id);

        if(!plant.isPresent()){
            return null;
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
