package com.simplon.dvdstore.controllers.dvds;

import lombok.AllArgsConstructor;
import lombok.Data;
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
@AllArgsConstructor
public class DvdStoreDTO {

    private String name;
    private String genre;
    private int quantite;
    private Float prix;
    private String picture;


}
