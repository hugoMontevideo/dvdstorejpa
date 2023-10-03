
package com.simplon.dvdstore.controllers.vente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteAddDTO {
    private String dateDeVente;
    private Long dvdstore_id;
    private int quantite;
    private Long client_id;

}
