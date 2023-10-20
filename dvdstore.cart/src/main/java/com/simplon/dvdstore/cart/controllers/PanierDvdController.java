package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.services.PanierDvdService;
import com.simplon.dvdstore.cart.services.PanierDvdServiceRequestModel;
import com.simplon.dvdstore.cart.services.PanierDvdServiceResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@CrossOrigin
@RestController
@RequestMapping("carts")
public class PanierDvdController {

    @Autowired
    PanierDvdService panierDvdService;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    @PostMapping("/panierdvd") //insère une ligne dans panier_dvd
    public ResponseEntity<String> insertIntoPanierDvd(@RequestBody PanierDvdInsertDTO panierDvdInsertDTO){

        PanierDvdServiceRequestModel panierDvdServiceRequestModel = dvdStoreCartMapper.insertDtoToServiceRequest(panierDvdInsertDTO);
        panierDvdService.insertIntoPanierDvd(panierDvdServiceRequestModel);

//        panierDvdService.savePanierDvd(new PanierDvdServiceRequestModel( panierDvdInsertDTO.getDvdId(), panierDvdInsertDTO.getPanierId(), panierDvdInsertDTO.getDvdQuantite(), panierDvdInsertDTO.getDvdPrix(), panierDvdInsertDTO.getClientId()));

        return new ResponseEntity<>("Le dvd  " + panierDvdInsertDTO.getDvdId() +" a été ajoutée"  , HttpStatus.OK) ;
    }

    @GetMapping("/panierdvd/{id}")   // findById table  panierDvd
    public ResponseEntity<PanierDvdResponseDTO> findById(@PathVariable Long id){
        try{
            PanierDvdServiceResponseModel panierDvdServiceResponseModel =  panierDvdService.findById(id);

            PanierDvdResponseDTO panierDvdResponseDTO = dvdStoreCartMapper.panierDvdServiceToDto(panierDvdServiceResponseModel);

//            PanierResponseDTO panierResponseDTO = new PanierResponseDTO( panierDvdServiceResponseModel.getPanier().getId(), panierDvdServiceResponseModel.getPanier().getAmount(), panierDvdServiceResponseModel.getPanier().getClientId(),
//                    panierDvdServiceResponseModel.getPanier().getCreatedAt());
//
//            return new ResponseEntity<>(new PanierDvdResponseDTO(panierDvdServiceResponseModel.getDvdId(), panierResponseDTO, panierDvdServiceResponseModel.getId(), panierDvdServiceResponseModel.getDvdSubtotal(),panierDvdServiceResponseModel.getClientId()),
//                    HttpStatus.OK) ;
            return new ResponseEntity<>( panierDvdResponseDTO,
                    HttpStatus.OK) ;
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage() );
        }
    }

}