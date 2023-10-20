package com.simplon.dvdstore.cart.services;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Optional;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PanierServiceModel {

//    Optional<Long> id;
    Long id;

    private Float amount;

    private Long clientId;

    private Long createdAt;

    private ArrayList<PanierDvdServiceResponseModel> dvds = new ArrayList<>();


}
