package com.simplon.dvdstore.controllers.feignclient;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PanierFeignBean {

    private Long id;
    private Float amount;
    private Long clientId;
    private Long createdAt;
    private List<PanierDvdFeignBean> dvds = new ArrayList<>() ;

    PanierFeignBean( Float amount){
        this.amount = amount;
    }

}
