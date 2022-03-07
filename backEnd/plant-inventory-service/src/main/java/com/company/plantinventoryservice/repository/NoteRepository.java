package com.company.plantinventoryservice.repository;

import com.company.plantinventoryservice.dto.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
}
