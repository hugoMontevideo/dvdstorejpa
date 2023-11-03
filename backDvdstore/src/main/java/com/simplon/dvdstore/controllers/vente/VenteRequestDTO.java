package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdInsertDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteRequestDTO {
    private Float amount;

    private Long clientId;

    private Long dateDeVente;

    private List<PanierDvdInsertDTO> dvds = new ArrayList<>();
}
