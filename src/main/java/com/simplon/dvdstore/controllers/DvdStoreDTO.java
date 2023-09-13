package com.simplon.dvdstore.controllers;


import lombok.Data;

public record DvdStoreDTO(String name, String genre) {
}



// @ Value de springboot
// si on recoit des valeurs de ce type

//public record DvdStoreDTO(String name, String genre, @Value("${url.genre}") String urlGenre) {
//}

// re

//import lombok.AllArgsConstructor;
//import lombok.Data;

//@Data
//
//public class DvdStoreDTO {
//
//    private String name;
//    public String genre;
//}
