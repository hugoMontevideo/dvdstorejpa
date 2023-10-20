package com.simplon.dvdstore.cart.services;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PanierDvdServiceResponseModel {

    private Long dvdId;

    private PanierServiceModel panier;

    private Long id;

    private Float dvdSubtotal;

    private Long clientId;

    private Integer dvdQuantite;
}
