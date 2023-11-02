package com.simplon.dvdstore.controllers.feignclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

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

    private Optional<String> nameDvd;


    PanierDvdFeignBean( Float amount){
        dvdSubtotal = amount;
    }


}
