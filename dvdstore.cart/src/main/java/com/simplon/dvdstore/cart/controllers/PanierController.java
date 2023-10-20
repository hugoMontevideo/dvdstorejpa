package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepository;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("carts")
public class PanierController {
    @Autowired
    PanierDvdService panierDvdService;
    @Autowired
    PanierService panierService;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    @PostMapping  // insert a cart
    ResponseEntity<String> insertPanier(@RequestBody PanierDTO panierDTO){

        boolean isOk = panierService.save(new PanierServiceModel(0L, panierDTO.getAmount(), panierDTO.getClientId(), panierDTO.getCreatedAt(), new ArrayList<>()));

        return new ResponseEntity<>("Le panier a été ajouté : " + isOk , HttpStatus.OK);
    }

    @DeleteMapping("/panier/{id}")  // Deleting a cart by Id
    public ResponseEntity<String> deletePanierById(@PathVariable Long id){
        if(panierService.findById(id) != null ){
            panierService.delete(id);
            return new ResponseEntity<>("le panier id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
            //  throw new NotFoundException(id);
            return new ResponseEntity<>("le panier id : " + id + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/panier/{id}")   // findById  table panier
    public ResponseEntity<PanierGetDTO> findPanierById(@PathVariable Long id){
        try{
            PanierServiceModel panierServiceModel =  panierService.findById(id);

            return new ResponseEntity<>(new PanierGetDTO(panierServiceModel.getId(),
                    panierServiceModel.getAmount(),panierServiceModel.getClientId(),panierServiceModel.getCreatedAt()),
                    HttpStatus.OK) ;
        }catch(Exception ex){

            System.out.println(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage() );
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
