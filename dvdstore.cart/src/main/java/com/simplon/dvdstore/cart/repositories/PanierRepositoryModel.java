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
@Table(name="panier")
public class PanierRepositoryModel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="dvd_id")
    private Long dvdId;
    @Column(name="panier_id")
    private Long PanierId;
    @Column(name="dvd_quantite")
    private Integer dvdQuantite;
    @Column(name="dvd_prix")
    private Long dvdPrix;

}
