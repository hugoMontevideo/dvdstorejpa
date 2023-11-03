package com.simplon.dvdstore.services.vente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteServiceRequestModel {

    private Float amount;

    private Long clientId;

    private Long dateDeVente;

//    private ArrayList<DetailVenteRequestModel> dvds = new ArrayList<>();

}
