package com.simplon.dvdstore.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierGetDTO {
    private Long Id;
    private String date_validate;
    private Float amount;
    private Long clientId;
}
