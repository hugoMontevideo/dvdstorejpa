package com.simplon.dvdstore.cart.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierDTO {
    private Long panierId;

    private Float amount;

    private Long clientId;

    private List<PanierDvdInsertDTO> dvds = new ArrayList<>();

}
