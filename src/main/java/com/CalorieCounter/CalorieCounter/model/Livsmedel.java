package com.CalorieCounter.CalorieCounter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class Livsmedel {

    @Id
    private Long id;

    private String namn;
    private int viktGram;


    @OneToMany(mappedBy = "livsmedel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Naringsvarde> naringsvarden;


    public Livsmedel(Long id, String namn, int viktGram, List<Naringsvarde> naringsvarden) {
        this.id = id;
        this.namn = namn;
        this.viktGram = viktGram;
        this.naringsvarden = naringsvarden;
    }

    public Livsmedel() {

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

    public int getViktGram() {
        return viktGram;
    }

    public void setViktGram(int viktGram) {
        this.viktGram = viktGram;
    }

    public List<Naringsvarde> getNaringsvarden() {
        return naringsvarden;
    }

    public void setNaringsvarden(List<Naringsvarde> naringsvarden) {
        this.naringsvarden = naringsvarden;
    }
}
