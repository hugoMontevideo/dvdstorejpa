package com.simplon.dvdstore.cart.controllers;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDvdResponseDTO {
    private Long id;

    private Long dvdId;

    private Long panierId;

    private Integer dvdQuantite;

    private Float dvdPrix;


}
