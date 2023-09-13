package com.simplon.dvdstore.services;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Optional;

@Data
@AllArgsConstructor
public class DvdServiceModel {

        private Optional<Long> id;
        private String name;
        private String genre;

        public DvdServiceModel(){

        }

        public DvdServiceModel(String name, String genre) {
                this.name = name;
                this.genre = genre;
        }


        @Override
        public String toString() {
                return "DvdServiceModel{" +
                        "name='" + name + '\'' +
                        ", genre='" + genre + '\'' +
                        '}';
        }
}
