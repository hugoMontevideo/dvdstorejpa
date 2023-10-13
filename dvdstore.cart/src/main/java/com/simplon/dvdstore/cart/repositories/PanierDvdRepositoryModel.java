package com.simplon.dvdstore.cart.repositories;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="panier_dvd")
public class PanierDvdRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="dvd_id")
    private Long dvdId;
    @Column(name="panier_id")
    private Long panierId;
    @Column(name="dvd_quantite")
    private Integer dvdQuantite;
    @Column(name="dvd_prix")
    private Float dvdPrix;
    @Column(name="client_id")
    private Long clientId;

}
