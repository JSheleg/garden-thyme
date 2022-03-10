package com.company.growzoneservice.repository;


import com.company.growzoneservice.dto.GrowZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrowZoneRepository extends JpaRepository<GrowZone, Integer> {


}
