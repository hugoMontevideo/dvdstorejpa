package com.simplon.dvdstore.services;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DvdServiceModel {

        private String name;

        private String genre;

}
