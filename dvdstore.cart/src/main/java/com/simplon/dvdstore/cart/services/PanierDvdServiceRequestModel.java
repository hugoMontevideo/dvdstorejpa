package com.simplon.dvdstore.cart.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierDvdServiceRequestModel {
    private Long dvdId;

    private Long panierId;

    private Float dvdSubtotal;

    private Long clientId;

    private Integer dvdQuantite;

//    private Float dvdPrix;

}
