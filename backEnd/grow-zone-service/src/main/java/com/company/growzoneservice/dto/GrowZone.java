package com.company.growzoneservice.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name ="grow_zone")
public class GrowZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer zoneId;
    //in Fahrenheit
    private Integer lowTemp;
    //in Fahrenheit
    private Integer highTemp;

    public GrowZone() {
    }

    public GrowZone(Integer zoneId, Integer lowTemp, Integer highTemp) {
        this.zoneId = zoneId;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
    }

    public Integer getZoneId() {
        return zoneId;
    }

    public void setZoneId(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public Integer getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(Integer lowTemp) {
        this.lowTemp = lowTemp;
    }

    public Integer getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(Integer highTemp) {
        this.highTemp = highTemp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrowZone growZone = (GrowZone) o;
        return Objects.equals(zoneId, growZone.zoneId) && Objects.equals(lowTemp, growZone.lowTemp) && Objects.equals(highTemp, growZone.highTemp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(zoneId, lowTemp, highTemp);
    }

    @Override
    public String toString() {
        return "GrowZone{" +
                "zoneId=" + zoneId +
                ", lowTemp=" + lowTemp +
                ", highTemp=" + highTemp +
                '}';
    }
}
