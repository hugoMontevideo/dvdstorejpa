package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.repositories.PanierDvdRepository;
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
@RequestMapping("cart")
public class PanierController {
    @Autowired
    PanierDvdService panierDvdService;
    @Autowired
    PanierDvdRepository panierDvdRepository;

    @PutMapping //insère une ligne dans panier_dvd
    public ResponseEntity<String> insertIntoPanierDvd(@RequestBody PanierDvdInsertDTO panierDvdInsertDTO){
        System.out.println(panierDvdInsertDTO);

        panierDvdService.savePanierDvd(new PanierDvdServiceRequestModel( panierDvdInsertDTO.getDvdId(), panierDvdInsertDTO.getPanierId(), panierDvdInsertDTO.getDvdQuantite(), panierDvdInsertDTO.getDvdPrix(), panierDvdInsertDTO.getClientId()));

        return new ResponseEntity<>("Le dvd  " + panierDvdInsertDTO.getDvdId() +" a été ajoutée", HttpStatus.OK) ;
    }
    @GetMapping("/{id}")   // findById
    public ResponseEntity<PanierDvdResponseDTO> findById(@PathVariable Long id){
        try{
            PanierDvdServiceResponseModel panierDvdServiceResponseModel =  panierDvdService.findById(id);
//
            return new ResponseEntity<>(new PanierDvdResponseDTO(panierDvdServiceResponseModel.getDvdId(),
                    panierDvdServiceResponseModel.getPanierId(),panierDvdServiceResponseModel.getDvdSubtotal(),panierDvdServiceResponseModel.getClientId()),
                    HttpStatus.OK) ;
//
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage() );
//
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(panierDvdService.findById(id) != null ){
            panierDvdService.delete(id);
            return new ResponseEntity<>("le dvd id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
            //  throw new NotFoundException(id);
            return new ResponseEntity<>("le dvd id : " + id + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping
    public String test(){
        return "helloworld";
    }
//    @PutMapping
//    public ResponseEntity<String> insertIntoPanierTest(@RequestBody PanierTestDto panierTestDto){
//        System.out.println(panierTestDto);
//
//        panierDvdRepository.saveTest2( panierTestDto.getDvdSubtotal(), panierTestDto.getClientId());
//
//        return new ResponseEntity<>("Le dvd  " + panierTestDto.getClientId() +" a été ajoutée", HttpStatus.OK) ;
//    }
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
