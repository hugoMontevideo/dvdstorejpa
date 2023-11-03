package com.simplon.dvdstore.repositories.vente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="vente")
public class VenteRepositoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "client_id")
    private Long clientId;

    @Column(name = "date_de_vente")
    private Long dateDeVente;

    @OneToMany(mappedBy ="vente", orphanRemoval = true)
    private List<DetailVenteRepositoryModel> dvds = new ArrayList<>();
}



