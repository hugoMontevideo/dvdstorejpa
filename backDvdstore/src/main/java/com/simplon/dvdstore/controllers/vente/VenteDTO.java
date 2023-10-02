package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteDTO {
    private Long dateDeVente;
    private Long dvdstore_id;
    private int quantite;
    private Long client_id;
    private Float montant;
    public VenteDTO(int quantite) {
        this.quantite = quantite;
    }

    public VenteDTO(Long dvdstore_id, int quantite, Long client_id) {
        this.dvdstore_id = dvdstore_id;
        this.quantite = quantite;
        this.client_id = client_id;
    }
}
