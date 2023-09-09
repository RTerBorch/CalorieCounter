package com.CalorieCounter.CalorieCounter.model;

import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;


@XmlRootElement(name = "LivsmedelDataset")  // This line sets the expected root element of the XML to match this class
public class LivsmedelDataset {
        private List<Livsmedel> LivsmedelsLista;
        // getters and setters

        public List<Livsmedel> getLivsmedelsLista() {
                return LivsmedelsLista;
        }

        public void setLivsmedelsLista(List<Livsmedel> livsmedelsLista) {
                LivsmedelsLista = livsmedelsLista;
        }
}
