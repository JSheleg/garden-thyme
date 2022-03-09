package com.company.plantinventoryservice.viewmodel;

import com.company.plantinventoryservice.dto.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PlantViewModel {
    private int id;
    private String nickname;
    private String plantName;
    private String scientificName;
    private String sunlightHours;
    private String waterFrequency;
    private Integer zoneId;
    private List<Note> notes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public String getScientificName() {
        return scientificName;
    }

    public void setScientificName(String scientificName) {
        this.scientificName = scientificName;
    }

    public String getSunlightHours() {
        return sunlightHours;
    }

    public void setSunlightHours(String sunlightHours) {
        this.sunlightHours = sunlightHours;
    }

    public String getWaterFrequency() {
        return waterFrequency;
    }

    public void setWaterFrequency(String waterFrequency) {
        this.waterFrequency = waterFrequency;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlantViewModel that = (PlantViewModel) o;
        return id == that.id && Objects.equals(nickname, that.nickname) && Objects.equals(plantName, that.plantName) && Objects.equals(scientificName, that.scientificName) && Objects.equals(sunlightHours, that.sunlightHours) && Objects.equals(waterFrequency, that.waterFrequency) && Objects.equals(zoneId, that.zoneId) && Objects.equals(notes, that.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, plantName, scientificName, sunlightHours, waterFrequency, zoneId, notes);
    }

    @Override
    public String toString() {
        return "PlantViewModel{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", plantName='" + plantName + '\'' +
                ", scientificName='" + scientificName + '\'' +
                ", sunlightHours='" + sunlightHours + '\'' +
                ", waterFrequency='" + waterFrequency + '\'' +
                ", zoneId=" + zoneId +
                ", notes=" + notes +
                '}';
    }
}
