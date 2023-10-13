package com.simplon.dvdstore.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierDTO {
//    private String date_validate;
//    private Float amount;
    private Long dvd_id;
    private Integer dvd_quantite;
    private Float dvd_prix;
    private Long clientId;
}
