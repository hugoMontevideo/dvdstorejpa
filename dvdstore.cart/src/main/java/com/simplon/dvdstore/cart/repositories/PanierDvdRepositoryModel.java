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
    @Column(name="dvd_id")
    private Long dvdId;

    @Column(name="panier_id")
    private Long panierId;

    @Column(name="dvd_subtotal")
    private Float dvdSubtotal;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="client_id")
    private Long clientId;




}
