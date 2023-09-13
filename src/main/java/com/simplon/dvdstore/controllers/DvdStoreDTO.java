package com.simplon.dvdstore.controllers;

public record DvdStoreDTO(String name, String genre) { }



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





//public class DvdStoreDTO {
//
//    private String name;
//    public String genre;
//
//    public DvdStoreDTO(String name, String genre) {
//        this.name=name;
//        this.genre=genre;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getGenre() {
//        return genre;
//    }
//
//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//}
