package com.simplon.dvdstore.services.vente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailVenteServiceRequestModel {
    private Long dvdId;

    private VenteServiceResponseModel vente;

    private Float dvdSubtotal;

    private Long clientId;

    private Integer dvdQuantite;

}
