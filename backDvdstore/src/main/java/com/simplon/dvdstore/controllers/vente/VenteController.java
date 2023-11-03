package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.controllers.client.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvds.DvdStoreGetDTO;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdFeignBean;
import com.simplon.dvdstore.controllers.feignclient.PanierDvdInsertDTO;
import com.simplon.dvdstore.mappers.DvdStoreMapper;
import com.simplon.dvdstore.services.client.ClientService;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import com.simplon.dvdstore.services.dvds.DvdStoreService;
import com.simplon.dvdstore.services.vente.VenteService;
import com.simplon.dvdstore.services.vente.VenteServiceModel;
import com.simplon.dvdstore.services.vente.VenteServiceRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


@CrossOrigin
@RestController
@RequestMapping
public class VenteController {
    @Autowired
    VenteService venteService;

    private final DvdStoreMapper dvdStoreMapper = DvdStoreMapper.INSTANCE;

//    @PostMapping("ventes")
//    public void add(@RequestBody VenteAddDTO venteAddDTO){
//
//        VenteRequestDTO venteRequestDTO = new VenteRequestDTO(
//                venteAddDTO.getAmount(), venteAddDTO.getClientId(), 0L, venteAddDTO.getDvds()
//        );
//
//        VenteServiceRequestModel venteServiceModel = dvdStoreMapper.venteDtoToService(venteRequestDTO);
//
//        ArrayList<Long> dvds = new ArrayList<>();
//        for(PanierDvdInsertDTO item : venteAddDTO.getDvds()) {
//            dvds.add(item.getDvdId());
//        }
//        venteServiceModel.setDvds(dvds);
//
//        venteService.add(venteServiceModel);
////
////        DvdServiceModel dvdServiceModel = dvdStoreService.findById(venteAddDTO.getDvdstore_id());
////
////        VenteServiceModel venteServiceModel = new VenteServiceModel(milliseconds, dvdServiceModel,
////        venteAddDTO.getQuantite(), clientService.findById(venteAddDTO.getClient_id()));
////
////        return venteService.add(venteServiceModel);
//    }

//    @GetMapping("dvdstore/ventes")
//    public ArrayList<VenteGetAllDTO> findAll(){
//        ArrayList<VenteGetAllDTO> venteGetAllDTOS = new ArrayList<>();
//        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAll() ;
//
////        venteServiceModels.forEach((item)->{
//        for ( VenteServiceModel item : venteServiceModels) {
//
//            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());
//
//            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());
//
//            venteGetAllDTOS.add(new VenteGetAllDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO.id(), dvdStoreGetDTO.name(), item.getQuantite(), clientGetDTO.getId(), clientGetDTO.getName(), item.getMontant()));
//           }
//        return venteGetAllDTOS;
//    }


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
//    @GetMapping("dvdstore/ventes/client/{id}")
//    public ArrayList<VenteGetDTO> findAllByIdClient(@PathVariable("id") Long id){
//        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
//        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllByClientId(id) ;
//
//        for ( VenteServiceModel item : venteServiceModels) {
//            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());
//
//            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());
//
//            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
//        }
//
//        return venteGetDTOS;
//    }

    // get all sales per dvd name/id
//    @GetMapping("dvdstore/ventes/dvd/{name}")
//    public ArrayList<VenteGetDTO> findAllByDvdName(@PathVariable("name") String name){
//        ArrayList<VenteGetDTO> venteGetDTOS = new ArrayList<>();
//        ArrayList<VenteServiceModel> venteServiceModels = venteService.findAllSalesByDvdName(name);
//
//        for ( VenteServiceModel item : venteServiceModels) {
//            DvdStoreGetDTO dvdStoreGetDTO = new DvdStoreGetDTO(item.getDvdServiceModel().getId().get(), item.getDvdServiceModel().getName(), item.getDvdServiceModel().getGenre(), item.getDvdServiceModel().getQuantite(), item.getDvdServiceModel().getPrix(), item.getDvdServiceModel().getPicture());
//
//            ClientGetDTO clientGetDTO = new ClientGetDTO(item.getClientServiceModel().getId().get(), item.getClientServiceModel().getName(), item.getClientServiceModel().getFirstname(), item.getClientServiceModel().getEmail(), item.getClientServiceModel().getAdresse());
//
//            venteGetDTOS.add(new VenteGetDTO(item.getId().get(), item.getDateDeVente(), dvdStoreGetDTO, item.getQuantite(), clientGetDTO, item.getMontant()));
//        }
//        return venteGetDTOS;
//    }




}
