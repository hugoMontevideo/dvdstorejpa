package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailVenteServiceModel {
    private Long dvdId;

    private VenteRepositoryModel vente;

    private Long id;

    private Float dvdSubtotal;

    private Long clientId;

    private Integer dvdQuantite;
}
