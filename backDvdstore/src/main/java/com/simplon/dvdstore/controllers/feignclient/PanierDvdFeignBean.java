package com.simplon.dvdstore.controllers.feignclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierDvdFeignBean {
    private Long dvdId;

    private Long panierId;

    private Float dvdSubtotal;

    private Long clientId;

    PanierDvdFeignBean( Float amount){
        dvdSubtotal = amount;
    }


}
