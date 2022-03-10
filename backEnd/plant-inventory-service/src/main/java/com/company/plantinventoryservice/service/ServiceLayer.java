package com.company.plantinventoryservice.service;

import com.company.plantinventoryservice.dto.Note;
import com.company.plantinventoryservice.dto.Plant;
import com.company.plantinventoryservice.repository.NoteRepository;
import com.company.plantinventoryservice.repository.PlantRepository;
import com.company.plantinventoryservice.viewmodel.PlantViewModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ServiceLayer {
    private PlantRepository plantRepository;
    private NoteRepository noteRepository;

    @Autowired
    public ServiceLayer(PlantRepository plantRepository, NoteRepository noteRepository) {
        this.plantRepository = plantRepository;
        this.noteRepository = noteRepository;
    }

    @Transactional
    public PlantViewModel savePlant(PlantViewModel viewModel){
            Plant a = new Plant();
            a.setPlantName(viewModel.getPlantName());
            a.setNickname(viewModel.getNickname());
            a.setScientificName(viewModel.getScientificName());
            a.setSunlightHours(viewModel.getSunlightHours());
            a.setWaterFrequency(viewModel.getWaterFrequency());
            a = plantRepository.save(a);
            viewModel.setId(a.getId());

            List<Note> notes = viewModel.getNotes();
            notes.stream()
                    .forEach(n ->
                    {
                        n.setPlantId(viewModel.getId());
                        noteRepository.save(n);
                    });
            notes = noteRepository.findAllNotesByPlantId(viewModel.getId());
            viewModel.setNotes(notes);

            return viewModel;
    }
    public PlantViewModel findPlant(int id){
        Optional<Plant> plant = plantRepository.findById(id);
        return plant.isPresent() ? buildPlantViewModel(plant.get()): null;
    }

    private PlantViewModel buildPlantViewModel(Plant plant){
        //get associated notes
        List<Note> noteList = noteRepository.findAllNotesByPlantId(plant.getId());

        //Build the PlantViewModel
        PlantViewModel pvm = new PlantViewModel();
        pvm.setId(plant.getId());
        pvm.setPlantName(plant.getPlantName());
        pvm.setNickname(plant.getNickname());
        pvm.setScientificName(plant.getScientificName());
        pvm.setSunlightHours(plant.getSunlightHours());
        pvm.setWaterFrequency(plant.getWaterFrequency());
        pvm.setNotes(noteList);

        return pvm;
    }

    public List<PlantViewModel> findAllPlants(){
        List<Plant> plantList = plantRepository.findAll();
        List<PlantViewModel> pvmList = new ArrayList<>();
        for(Plant plant: plantList){
            PlantViewModel pvm = buildPlantViewModel(plant);
            pvmList.add(pvm);
        }
        return pvmList;
    }

    @Transactional
    public void updatePlant(PlantViewModel viewModel){
        //update plant information
        Plant plant = new Plant();
        plant.setId(viewModel.getId());
        plant.setPlantName(viewModel.getPlantName());
        plant.setNickname(viewModel.getNickname());
        plant.setScientificName(viewModel.getScientificName());
        plant.setSunlightHours(viewModel.getSunlightHours());
        plant.setWaterFrequency(viewModel.getWaterFrequency());

        plantRepository.save(plant);

        List<Note> noteList = noteRepository.findAllNotesByPlantId(plant.getId());
        noteList.stream()
                .forEach(note -> noteRepository.deleteById(note.getId()));

        List<Note> notes = viewModel.getNotes();
        notes.stream()
                .forEach(n ->
                {
                    n.setPlantId(viewModel.getId());
                    n = noteRepository.save(n);

                });
    }

    @Transactional
    public  void removePlant(int id){
        //remove all associated notes
        List<Note> noteList = noteRepository.findAllNotesByPlantId(id);
        noteList.stream()
                .forEach(note -> noteRepository.deleteById((note.getId())));

        //remove plant
        plantRepository.deleteById(id);
    }
}
