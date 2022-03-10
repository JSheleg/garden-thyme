package com.company.plantinventoryservice.repository;

import com.company.plantinventoryservice.dto.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository  extends JpaRepository <Plant, Integer> {
}
