
package com.simplon.dvdstore.controllers.vente;


import com.simplon.dvdstore.controllers.feignclient.PanierDvdInsertDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VenteAddDTO {

    private Long panierId;

    private Float amount;

    private Long clientId;

    private List<PanierDvdInsertDTO> dvds = new ArrayList<>();

}
