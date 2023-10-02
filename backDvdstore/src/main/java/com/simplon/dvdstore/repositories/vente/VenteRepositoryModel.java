package com.simplon.dvdstore.repositories.vente;

import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vente")
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

//    @CreationTimestamp
    @Column(name="date_de_vente")
    Long dateDeVente;

    @ManyToOne
    @JoinColumn(name = "dvdstore_id")
    @OnDelete(action = OnDeleteAction.SET_NULL)
    private DvdRepositoryModel dvdRepositoryModel;

    @Column(name="quantite")
    private int quantite;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private ClientRepositoryModel clientRepositoryModel;

    @JoinColumn(name="montant")
    Float montant;

    public VenteRepositoryModel(int quantite) {
        this.quantite = quantite;
    }

    public VenteRepositoryModel(Long date, DvdRepositoryModel dvdRepositoryModel, int quantite, ClientRepositoryModel clientRepositoryModel) {
        this.dateDeVente = date;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.quantite = quantite;
        this.clientRepositoryModel = clientRepositoryModel;
    }

    public VenteRepositoryModel(DvdRepositoryModel dvdRepositoryModel, int quantite, ClientRepositoryModel clientRepositoryModel) {
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.quantite = quantite;
        this.clientRepositoryModel = clientRepositoryModel;
    }

    public VenteRepositoryModel(Long dateDeVente, DvdRepositoryModel dvdRepositoryModel, int quantite, ClientRepositoryModel clientRepositoryModel, Float montant) {
        this.dateDeVente = dateDeVente;
        this.dvdRepositoryModel = dvdRepositoryModel;
        this.quantite = quantite;
        this.clientRepositoryModel = clientRepositoryModel;
        this.montant = montant;
    }
}
