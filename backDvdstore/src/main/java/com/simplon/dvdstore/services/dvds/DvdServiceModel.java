package com.simplon.dvdstore.services.dvds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdServiceModel {

        public Optional<Long> id;
        private String name;
        private String genre;
        private int quantite;
        private Float prix;


        public DvdServiceModel(String name, String genre) {
                this.name = name;
                this.genre = genre;
        }

        public DvdServiceModel(String name, String genre, int quantite) {
                this.name = name;
                this.genre = genre;
                this.quantite = quantite;
        }

        public DvdServiceModel(String name, String genre, int quantite, Float prix) {
                this.name = name;
                this.genre = genre;
                this.quantite = quantite;
                this.prix = prix;
        }

        @Override
        public String toString() {
                return "DvdServiceModel{" +
                        "name='" + name + '\'' +
                        ", genre='" + genre + '\'' +
                        '}';
        }

}
