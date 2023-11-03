package com.simplon.dvdstore.cart.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierResponseServiceModel {
    private Long id;

    private Float amount;

    private Long clientId;

    private Long createdAt;

}
