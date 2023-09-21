package com.simplon.dvdstore.repositories.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="client")
public class ClientRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="firstname")
    private String firstname;
    @Column(name="email")
    private String email;
    @Column(name="adresse")
    private String adresse;


    public ClientRepositoryModel(String name, String firstname, String email, String adresse) {
        this.name = name;
        this.firstname = firstname;
        this.email = email;
        this.adresse = adresse;
    }
}
