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

    @Column(name="amount")
    private Float amount;

    @Column(name="client_id")
    private Long clientId;

    @Column(name="created_at")
    private Long createdAt;

}
