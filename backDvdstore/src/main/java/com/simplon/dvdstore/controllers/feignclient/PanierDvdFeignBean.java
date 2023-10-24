package com.simplon.dvdstore.controllers.feignclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDvdFeignBean {

    private Long dvdId;

    private PanierFeignBean panier;

    private Long id;

    private Float dvdSubtotal;

    private Long clientId;

    private Integer dvdQuantite;


    PanierDvdFeignBean( Float amount){
        dvdSubtotal = amount;
    }


}
