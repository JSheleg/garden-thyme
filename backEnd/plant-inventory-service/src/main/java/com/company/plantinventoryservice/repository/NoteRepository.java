package com.company.plantinventoryservice.repository;

import com.company.plantinventoryservice.dto.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {
    List<Note> findAllNotesByPlantId(int plantId);

}
