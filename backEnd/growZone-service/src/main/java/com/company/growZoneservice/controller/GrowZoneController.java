package com.company.growZoneservice.controller;



import com.company.growZoneservice.dto.GrowZone;
import com.company.growZoneservice.repository.GrowZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class GrowZoneController {

    @Autowired
    private GrowZoneRepository growZoneRepository;

    @PostMapping("/growZone")
    public GrowZone createZone(@RequestBody GrowZone zone){
        growZoneRepository.save(zone);
        return zone;
    }

    @GetMapping("/growZone")
    public List<GrowZone> getZoneById() {

        return growZoneRepository.findAll();
    }

    @GetMapping("/growZone/{id}")
    public GrowZone getGrowZoneById(@PathVariable Integer zoneId){
        Optional<GrowZone> zone = growZoneRepository.findById(zoneId);

        return zone.get();
    }

    @PutMapping("/growZone/{id}")
    public void updateZone(@RequestBody GrowZone zone, @PathVariable Integer id){
        growZoneRepository.save(zone);
    }

    @DeleteMapping("/growZone/{id}")
    public void deleteZone(@RequestBody GrowZone zone, @PathVariable Integer id){
        growZoneRepository.delete(zone);
    }
}
