package com.company.plantinventoryservice.dto;

import com.fasterxml.jackson.annotation.*;
import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name="plant")
public class Plant implements Serializable {

    @Id
    @Column(name = "plant_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message="You must supply a nickname")
    private String nickname;
    @NotEmpty(message="You must supply a plantName")
    private String plantName;
    private String scientificName;
    @NotEmpty(message="You must supply sunlightHours")
    private String sunlightHours;
    @NotEmpty(message="You must supply waterFrequency")
    private String waterFrequency;
    private Integer zoneId;

    @OneToMany(mappedBy = "plantId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Note> notes;


    public Plant(String nickname, String plantName, String scientificName, String sunlightHours, String waterFrequency, Integer zoneId) {
        this.nickname = nickname;
        this.plantName = plantName;
        this.scientificName = scientificName;
        this.sunlightHours = sunlightHours;
        this.waterFrequency = waterFrequency;
        this.zoneId = zoneId;
    }

    public Plant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Set<Note> getNotes() {
        return notes;
    }

    public void setNotes(Set<Note> notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Plant plant = (Plant) o;
        return Objects.equals(id, plant.id) && Objects.equals(nickname, plant.nickname) && Objects.equals(plantName, plant.plantName) && Objects.equals(scientificName, plant.scientificName) && Objects.equals(sunlightHours, plant.sunlightHours) && Objects.equals(waterFrequency, plant.waterFrequency) && Objects.equals(zoneId, plant.zoneId) && Objects.equals(notes, plant.notes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nickname, plantName, scientificName, sunlightHours, waterFrequency, zoneId, notes);
    }

    @Override
    public String toString() {
        return "Plant{" +
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
