package com.company.growZoneservice.controller;



import com.company.growZoneservice.dto.GrowZone;
import com.company.growZoneservice.repository.GrowZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GrowZoneController {

    @Autowired
    private GrowZoneRepository growZoneRepository;

    @PostMapping("/growZone")
    @ResponseStatus(HttpStatus.CREATED)
    public GrowZone createZone(@RequestBody GrowZone zone){
        return growZoneRepository.save(zone);
    }

    @GetMapping("/growZone")
    @ResponseStatus(HttpStatus.OK)
    public List<GrowZone> getAllZones() {
        return growZoneRepository.findAll();
    }

    @GetMapping("/growZone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public GrowZone getGrowZoneById(@PathVariable Integer zoneId){
        Optional<GrowZone> zone = growZoneRepository.findById(zoneId);

        return zone.get();
    }

    @PutMapping("/growZone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateZone(@RequestBody GrowZone zone){
        growZoneRepository.save(zone);
    }

    @DeleteMapping("/growZone/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteZone(@PathVariable Integer zoneId){
        growZoneRepository.deleteById(zoneId);
    }
}
