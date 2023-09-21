package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.services.vente.VenteService;
import com.simplon.dvdstore.services.vente.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("ventes")
public class VenteController {

    @Autowired
    VenteService venteService;

    @PostMapping
    public boolean add(@RequestBody VenteDTO venteDTO){
        VenteServiceModel venteServiceModel = new VenteServiceModel(venteDTO.getDvdstore_id(), venteDTO.getQuantite(), venteDTO.getClient_id());
//        VenteServiceModel venteServiceModel = new VenteServiceModel(  venteDTO.getQuantite());
        return venteService.add(venteServiceModel);
    }

}
