package com.company.growzoneservice.controller;



import com.company.growzoneservice.dto.GrowZone;
import com.company.growzoneservice.repository.GrowZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
public class GrowZoneController {

    @Autowired
    private GrowZoneRepository growZoneRepository;

    @PostMapping("/zone")
    @ResponseStatus(HttpStatus.CREATED)
    public GrowZone createZone(@RequestBody GrowZone zone){
        return growZoneRepository.save(zone);
    }

    @GetMapping("/zone")
    @ResponseStatus(HttpStatus.OK)
    public List<GrowZone> getAllZones() {
        return growZoneRepository.findAll();
    }

    @GetMapping("/zone/{zoneId}")
    @ResponseStatus(HttpStatus.OK)
    public GrowZone getGrowZoneById(@PathVariable Integer zoneId){
        Optional<GrowZone> zone = growZoneRepository.findById(zoneId);

        return zone.get();
    }

    @PutMapping("/zone/{zoneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateZone(@RequestBody GrowZone zone, @PathVariable Integer zoneId){
        growZoneRepository.save(zone);
    }

    @DeleteMapping("/zone/{zoneId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteZone(@PathVariable Integer zoneId){
        growZoneRepository.deleteById(zoneId);

    }
}
