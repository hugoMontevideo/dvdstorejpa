package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VenteServiceModel {

    private Optional<Long> id;
    private Long dateDeVente;
    private Long dvdstore_id;
    private int quantite;
    private Long client_id;
    private Float montant;

    public VenteServiceModel(int quantite) {
        this.quantite = quantite;
    }

    public VenteServiceModel(Long dvdstore_id, int quantite, Long client_id) {
        this.dvdstore_id = dvdstore_id;
        this.quantite = quantite;
        this.client_id = client_id;
    }
}
