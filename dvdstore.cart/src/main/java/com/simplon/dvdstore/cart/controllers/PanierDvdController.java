package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.services.PanierDvdService;
import com.simplon.dvdstore.cart.services.PanierDvdServiceRequestModel;
import com.simplon.dvdstore.cart.services.PanierDvdServiceResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

//@CrossOrigin(origins = "http://localhost:80")
@CrossOrigin
@RestController
@RequestMapping()
public class PanierDvdController {
    @Autowired
    PanierDvdService panierDvdService;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    @PostMapping("/clients/{id}/panier/panierdvd") //     insère une ligne dans panier_dvd   **  final version **
    public ResponseEntity<String> insertIntoPanierDvd(@RequestBody PanierDvdInsertDTO panierDvdInsertDTO){

        PanierDvdServiceRequestModel panierDvdServiceRequestModel = dvdStoreCartMapper.insertDtoToServiceRequest(panierDvdInsertDTO);

        panierDvdService.insertIntoPanierDvd(panierDvdServiceRequestModel);


//        PanierDvdResponseDTO panierDvdResponseDTO = dvdStoreCartMapper.panierDvdServiceToDto(panierDvdServiceResponseModel);
//        // insertion de l'objet panier dans panierdvd
//        panierDvdResponseDTO.setPanier(dvdStoreCartMapper.panierServiceToDTO(panierDvdServiceResponseModel.getPanier()));

        return new ResponseEntity<>("panier dvd inséré", HttpStatus.OK) ;
    }


    @DeleteMapping("/clients/{id}/panier/panierdvd/{id_panierdvd}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id,@PathVariable("id_panierdvd") Long idPanierdvd){
        if(panierDvdService.findById(idPanierdvd) != null ){
            panierDvdService.delete(idPanierdvd, id);
            return new ResponseEntity<>("le dvd id : " + idPanierdvd + " a été supprimé", HttpStatus.OK);
        }else{
            //  throw new NotFoundException(id);
            return new ResponseEntity<>("le dvd id : " + idPanierdvd + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/panierdvd/{id}")   // findById table  panierDvd
    public ResponseEntity<PanierDvdResponseDTO> findById(@PathVariable Long id){
        System.out.println("hiii");
        try{
            PanierDvdServiceResponseModel panierDvdServiceResponseModel =  panierDvdService.findById(id);

            PanierDvdResponseDTO panierDvdResponseDTO = dvdStoreCartMapper.panierDvdServiceToDto(panierDvdServiceResponseModel);


            return new ResponseEntity<>( panierDvdResponseDTO,
                    HttpStatus.OK) ;
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage() );
        }
    }



}

//            PanierResponseDTO panierResponseDTO = new PanierResponseDTO( panierDvdServiceResponseModel.getPanier().getId(), panierDvdServiceResponseModel.getPanier().getAmount(), panierDvdServiceResponseModel.getPanier().getClientId(),
//                    panierDvdServiceResponseModel.getPanier().getCreatedAt());
//
//            return new ResponseEntity<>(new PanierDvdResponseDTO(panierDvdServiceResponseModel.getDvdId(), panierResponseDTO, panierDvdServiceResponseModel.getId(), panierDvdServiceResponseModel.getDvdSubtotal(),panierDvdServiceResponseModel.getClientId()),
//                    HttpStatus.OK) ;


//    @PostMapping("/clients/{id}/panier/panierdvd") //insère une ligne dans panier_dvd   **  final version **
//    public ResponseEntity<PanierDvdResponseDTO> insertIntoPanierDvd(@RequestBody PanierDvdInsertDTO panierDvdInsertDTO){
//
//        PanierDvdServiceRequestModel panierDvdServiceRequestModel = dvdStoreCartMapper.insertDtoToServiceRequest(panierDvdInsertDTO);
//
//        PanierDvdServiceResponseModel panierDvdServiceResponseModel = panierDvdService.insertIntoPanierDvd(panierDvdServiceRequestModel);
//        PanierDvdResponseDTO panierDvdResponseDTO = dvdStoreCartMapper.panierDvdServiceToDto(panierDvdServiceResponseModel);
//        // insertion de l'objet panier dans panierdvd
//        panierDvdResponseDTO.setPanier(dvdStoreCartMapper.panierServiceToDTO(panierDvdServiceResponseModel.getPanier()));
//
//        return new ResponseEntity<>(panierDvdResponseDTO, HttpStatus.OK) ;
//    }