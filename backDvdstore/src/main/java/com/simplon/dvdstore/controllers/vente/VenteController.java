package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.controllers.client.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvds.DvdStoreGetDTO;
import com.simplon.dvdstore.repositories.vente.VenteRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import com.simplon.dvdstore.services.client.ClientService;
import com.simplon.dvdstore.services.dvds.DvdStoreService;
import com.simplon.dvdstore.services.vente.VenteService;
import com.simplon.dvdstore.services.vente.VenteServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("ventes")
public class VenteController {
    @Autowired
    VenteService venteService;
    @Autowired
    DvdStoreService dvdStoreService;
    @Autowired
    ClientService clientService;

    @PostMapping
    public boolean add(@RequestBody VenteDTO venteDTO){

        VenteServiceModel venteServiceModel = new VenteServiceModel(
                dvdStoreService.findById(venteDTO.getDvdstore_id()),
                venteDTO.getQuantite(),
                clientService.findById(venteDTO.getClient_id()));

        return venteService.add(venteServiceModel);
    }

    @GetMapping
    public ArrayList<VenteGetDTO> findAll(){

        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAll() ;

//        venteServiceModels.forEach((item)->{
        for ( VenteServiceModel item : venteServiceModels) {
            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());

            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());

            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
           }
        return venteGetDTOS;
    }


    //get all sales per client by name/id
//    @GetMapping("/client/{id}")
//    public ArrayList<VenteGetDTO> findAllById(@PathVariable Long id){
//        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
//        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllById(id) ;
//        System.out.println("hello world");
//        for ( VenteServiceModel item : venteServiceModels) {
//            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix());
//
//            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());
//
//            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
//        }
//        return venteGetDTOS;
//    }
    @GetMapping("/client/{id}")
    public ArrayList<VenteGetDTO> findAllByIdClient(@PathVariable("id") Long id){
        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllByClientId(id) ;

        for ( VenteServiceModel item : venteServiceModels) {
            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());

            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());

            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
        }

        return venteGetDTOS;
    }

    // get all sales per dvd name/id
    @GetMapping("/dvd/{name}")
    public ArrayList<VenteGetDTO> findAllByDvdName(@PathVariable("name") String name){
        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllSalesByDvdName(name);

        for ( VenteServiceModel item : venteServiceModels) {
            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());

            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());

            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
        }
        return venteGetDTOS;
    }




}
