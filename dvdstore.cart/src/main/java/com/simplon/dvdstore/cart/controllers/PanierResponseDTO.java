package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierResponseDTO {
    private Long id;

    private Float amount;

    private Long clientId;

    private Long createdAt;

    private List<PanierDvdResponseDTO> dvds = new ArrayList<>() ;

}
