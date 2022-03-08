package com.company.growZoneservice.repository;

import com.company.growZoneservice.dto.GrowZone;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GrowZoneRepositoryTest {

    @Autowired
    GrowZoneRepository zoneRepo;

    private GrowZone zone;


    @Before
    public void setUp() throws Exception {
        zoneRepo.deleteAll();

        zone = new GrowZone();

        zone.setZoneId(5);
        zone.setLowTemp(-20);
        zone.setHighTemp(-10);

    }


    @Test
    public void shouldAddGetZoneFromDatabase() {

        zone = zoneRepo.save(zone);

        GrowZone fromRepo = zoneRepo.findById(zone.getZoneId()).get();
        assertEquals(zone, fromRepo);
    }

    @Test
    public void shouldUpdateZoneInDatabase() {

        zoneRepo.save(zone);

        zone.setLowTemp(-3);

        zone = zoneRepo.save(zone);

        GrowZone fromRepo = zoneRepo.findById(zone.getZoneId()).get();
        assertEquals(zone, fromRepo);
    }

    @Test
    public void shouldDeleteCarFromDatabase() {
        zone = zoneRepo.save(zone);

        zoneRepo.save(zone);

        zoneRepo.deleteById(zone.getZoneId());

        Optional<GrowZone> fromRepo = zoneRepo.findById(zone.getZoneId());

        assertFalse(fromRepo.isPresent());
    }
}