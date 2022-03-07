package com.company.plantinventoryservice.repository;

import com.company.plantinventoryservice.dto.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository  extends JpaRepository<Plant, Integer> {
    //find by scientific name or plant name
    //find by water frequency
    //find by sunlight hours


}
