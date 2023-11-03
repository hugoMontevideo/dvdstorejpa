package com.simplon.dvdstore.services.vente;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteServiceResponseModel {
    private Long id;

    private Float amount;

    private Long clientId;

    private Long dateDeVente;

    private ArrayList<DetailVenteServiceModel> dvds = new ArrayList<>();
}
