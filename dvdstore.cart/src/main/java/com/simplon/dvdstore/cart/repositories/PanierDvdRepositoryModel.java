package com.simplon.dvdstore.cart.repositories;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="panier_dvd")
public class PanierDvdRepositoryModel {
    @Column(name="dvd_id")
    private Long dvdId;

    @ManyToOne
    @JoinColumn(name="panier_id")
    private PanierRepositoryModel panier;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="dvd_subtotal", columnDefinition = "REAL")
    private Float dvdSubtotal;

    @Column(name="client_id")
    private Long clientId;

    @Column(name="dvd_quantite")
    private Integer dvdQuantite;


//    @Column(name="dvd_quantite")
//    private Long dvdQuantite;

}
