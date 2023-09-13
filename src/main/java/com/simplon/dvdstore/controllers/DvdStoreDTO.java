package com.simplon.dvdstore.controllers;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


//public record DvdStoreDTO(String name, String genre) {
//
//}



// @ Value de springboot
//// si on recoit des valeurs de ce type
//////
//public record DvdStoreDTO(String name, String genre, @Value("${url.genre}") String urlGenre) {
//}

// re
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.Getter;

//@Getter


@Data
@NoArgsConstructor
public class DvdStoreDTO {

    private String name;
    private String genre;


    public DvdStoreDTO(String name, String genre) {
        this.name=name;
        this.genre=genre;
    }

}
