package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.repositories.PanierDvdRepository;
import com.simplon.dvdstore.cart.services.PanierDvdService;
import com.simplon.dvdstore.cart.services.PanierDvdServiceRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("cart")
public class PanierController {
    @Autowired
    PanierDvdService panierDvdService;
    @Autowired
    PanierDvdRepository panierDvdRepository;

    @PostMapping
    public ResponseEntity<String> insertIntoPanier(@RequestBody PanierDvdInsertDTO panierDvdInsertDTO){

        panierDvdService.savePanierDvd(new PanierDvdServiceRequestModel( panierDvdInsertDTO.getDvdId(), panierDvdInsertDTO.getPanierId(), panierDvdInsertDTO.getDvdQuantite(), panierDvdInsertDTO.getDvdPrix(), panierDvdInsertDTO.getClientId()));

        return new ResponseEntity<>("Le dvd  " + panierDvdInsertDTO.getDvdId() +" a été ajoutée", HttpStatus.OK) ;
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<PanierDvdResponseDTO> findById(@PathVariable Long id){
//        try{
//            PanierDvdServiceModel panierDvdServiceModel =  panierDvdService.findById(id);
////                DvdStoreDTO dvdStoreDTO = new DvdStoreDTO(dvdServiceModel.getName(),dvdServiceModel.getGenre(),dvdServiceModel.getQuantite(),dvdServiceModel.getPrix(),dvdServiceModel.getPicture());
//            return new ResponseEntity<>(new PanierDvdResponseDTO( panierDvdServiceModel.getId(), panierDvdServiceModel.getDvdId(),panierDvdServiceModel.getPanierId(),panierDvdServiceModel.getDvdQuantite(),panierDvdServiceModel.getDvdPrix()), HttpStatus.OK) ;
//
//        }catch(DvdNotF+oundException ex){
//
//            System.out.println(ex.getReason());
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND, ex.getReason() );
//
//        }
//    }



}
