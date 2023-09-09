package com.CalorieCounter.CalorieCounter.model;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
public class Naringsvarde {
    @Id
    @GeneratedValue
    private Long id;

    private String namn;
    private Double varde;
    private String enhet;

    @ManyToOne
    @JoinColumn(name= "livsmedel_id")
    private Livsmedel livsmedel;

    public Naringsvarde(String namn, Double varde, String enhet, Livsmedel livsmedel) {
        this.namn = namn;
        this.varde = varde;
        this.enhet = enhet;
        this.livsmedel = livsmedel;
    }

    public Naringsvarde() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamn() {
        return namn;
    }

    public void setNamn(String namn) {
        this.namn = namn;
    }

    public Double getVarde() {
        return varde;
    }

    public void setVarde(Double varde) {
        this.varde = varde;
    }

    public String getEnhet() {
        return enhet;
    }

    public void setEnhet(String enhet) {
        this.enhet = enhet;
    }

    public Livsmedel getLivsmedel() {
        return livsmedel;
    }

    public void setLivsmedel(Livsmedel livsmedel) {
        this.livsmedel = livsmedel;
    }
}
