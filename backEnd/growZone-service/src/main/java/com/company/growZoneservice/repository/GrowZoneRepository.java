package com.company.growZoneservice.repository;


import com.company.growZoneservice.dto.GrowZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowZoneRepository extends JpaRepository<GrowZone, Integer> {


}
