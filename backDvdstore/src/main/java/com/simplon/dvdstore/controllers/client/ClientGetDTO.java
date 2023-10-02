package com.simplon.dvdstore.controllers.client;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientGetDTO {
    private Long id;
    private String name;
    private String firstname;
    private String email;
    private String adresse;

}

