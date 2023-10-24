package com.simplon.dvdstore.cart.controllers;

import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

// @CrossOrigin(origins = "http://localhost:80")
@CrossOrigin
@RestController
@RequestMapping("carts")
public class PanierController {
    @Autowired
    PanierDvdService panierDvdService;
    @Autowired
    PanierService panierService;
    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    @PostMapping("/panier")  // insert a cart
    ResponseEntity<PanierResponseDTO> insertPanier(@RequestBody PanierDTO panierDTO){

        PanierServiceModel isOk = panierService.save(new PanierServiceModel(0L, 0F, panierDTO.getClientId(), panierDTO.getCreatedAt(), new ArrayList<>()));

        return new ResponseEntity<>( dvdStoreCartMapper.panierServiceToDTO(isOk) , HttpStatus.OK);
    }

    @GetMapping("/panier/{id}")   // findById  table panier
    public ResponseEntity<PanierResponseDTO> findPanierById(@PathVariable Long id){
        try{
            PanierServiceModel panierServiceModel =  panierService.findById(id);

            System.out.println(panierServiceModel);
            return new ResponseEntity<>( dvdStoreCartMapper.panierServiceToDTO(panierServiceModel) ,HttpStatus.OK) ;

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getMessage() );
        }
    }

    @GetMapping("/panier")
    public ArrayList<PanierResponseDTO> getAll(){
        ArrayList<PanierResponseDTO> panierResponseDTOS = new ArrayList<>();

        ArrayList<PanierServiceModel> panierServiceModels = panierService.findAll() ;
        panierServiceModels.forEach((item)->{
            PanierResponseDTO panierResponseDTO = dvdStoreCartMapper.panierServiceToDTO(item);
            panierResponseDTOS.add(panierResponseDTO);
            });

        return panierResponseDTOS;
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

//     add       DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());
//
//                ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());
//
//                venteGetAllDTOS.add(new VenteGetAllDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO.id(), dvdStoreGetDTO.name(), item.getQuantite(), clientGetDTO.getId(), clientGetDTO.getName(), item.getMontant()));
