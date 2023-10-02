package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
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
    private DvdServiceModel dvdServiceModel;
    private int quantite;
    private ClientServiceModel clientServiceModel;
    private Float montant;

    public VenteServiceModel(int quantite) {
        this.quantite = quantite;
    }

    public VenteServiceModel(DvdServiceModel dvdServiceModel, int quantite, ClientServiceModel clientServiceModel) {
        this.dvdServiceModel = dvdServiceModel;
        this.quantite = quantite;
        this.clientServiceModel = clientServiceModel;
    }

    public VenteServiceModel(Long dateDeVente, DvdServiceModel dvdServiceModel, int quantite, ClientServiceModel clientServiceModel) {
        this.dateDeVente = dateDeVente;
        this.dvdServiceModel = dvdServiceModel;
        this.quantite = quantite;
        this.clientServiceModel = clientServiceModel;
    }

    public VenteServiceModel(Long dateDeVente, DvdServiceModel dvdServiceModel, int quantite, ClientServiceModel clientServiceModel, Float montant) {
        this.dateDeVente = dateDeVente;
        this.dvdServiceModel = dvdServiceModel;
        this.quantite = quantite;
        this.clientServiceModel = clientServiceModel;
        this.montant = montant;
    }
}
