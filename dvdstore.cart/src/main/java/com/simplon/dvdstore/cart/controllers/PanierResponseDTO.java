package com.simplon.dvdstore.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierResponseDTO {
    Long id;

    private Float amount;

    private Long clientId;

    private Long createdAt;

}
