package com.simplon.dvdstore.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierDvdInsertDTO {

    private Long dvdId;

    private Long panierId;

    private Integer dvdQuantite;

    private Float dvdPrix;

    private Long clientId;

}
