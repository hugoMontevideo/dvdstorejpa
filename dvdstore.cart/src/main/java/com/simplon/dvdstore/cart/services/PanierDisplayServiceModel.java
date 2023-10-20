package com.simplon.dvdstore.cart.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierDisplayServiceModel {

    Long id;

    private Float amount;

    private Long clientId;

    private Long createdAt;

}
