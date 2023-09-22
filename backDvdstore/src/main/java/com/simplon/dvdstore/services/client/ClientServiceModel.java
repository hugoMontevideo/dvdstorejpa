package com.simplon.dvdstore.services.client;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientServiceModel {

    public Optional<Long> id;
    private String name;
    private String firstname;
    private String email;
    private String adresse;

    public ClientServiceModel(String name, String firstname, String email, String adresse) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.adresse = adresse;
    }
}
