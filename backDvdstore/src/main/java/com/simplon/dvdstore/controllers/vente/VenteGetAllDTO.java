package com.simplon.dvdstore.controllers.vente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteGetAllDTO {
    private Long id;
    private Long dateDeVente;
    private Long dvdstore_id;
    private String dvdstore_name;
    private int quantite;
    private Long client_id;
    private String client_name;
    private Float montant;
}
