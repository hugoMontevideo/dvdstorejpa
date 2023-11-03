package com.simplon.dvdstore.repositories.vente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vente_detail")
public class DetailVenteRepositoryModel {

    @Column(name="dvd_id")
    private Long dvdId;

    @ManyToOne
    @JoinColumn(name="vente_id")
    private VenteRepositoryModel vente;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="dvd_subtotal", columnDefinition = "REAL")
    private Float dvdSubtotal;

    @Column(name="client_id")
    private Long clientId;

    @Column(name="dvd_quantite")
    private Integer dvdQuantite;

}
