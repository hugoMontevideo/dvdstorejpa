package com.simplon.dvdstore.cart.services;

import com.simplon.dvdstore.cart.controllers.PanierDTO;
import com.simplon.dvdstore.cart.controllers.PanierGetDTO;
import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repositories.PanierRepository;
import com.simplon.dvdstore.cart.repositories.PanierRepositoryModel;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service
public class PanierService {
    @Autowired
    PanierRepository panierRepository;

    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    public PanierServiceModel save(PanierServiceModel panierServiceModel) {

        ArrayList<PanierDvdRepositoryModel>  panierDvdRepositoryModels = new ArrayList<>();
        Date date = new Date();
        Long  millisecDate = date.getTime();

        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(
               0L,
                panierServiceModel.getAmount(),
                panierServiceModel.getClientId(),
                millisecDate,
                panierDvdRepositoryModels);
        PanierRepositoryModel panierRepositoryModelReturn = panierRepository.save(panierRepositoryModel);

        return dvdStoreCartMapper.panierRepositoryToService2(panierRepositoryModelReturn);
    }

    @Transactional  // gère le debut et la fin du commit
    public PanierServiceModel findById(Long id) {
        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(id);
        if(panierRepositoryModel.isPresent()){
            return dvdStoreCartMapper.panierRepositoryToService2(panierRepositoryModel.get());
        }
        return null;
    }


    @Transactional
    public ArrayList<PanierServiceModel> findAll() {

        ArrayList<PanierServiceModel> panierServiceModels = new ArrayList<>();

        ArrayList<PanierRepositoryModel> panierRepositoryModels = panierRepository.findAll();

        panierRepositoryModels.forEach( (item)->{
            PanierServiceModel dvdServiceModel = dvdStoreCartMapper.panierRepositoryToService2(item);
            panierServiceModels.add(dvdServiceModel);
        });

        return panierServiceModels;
    }

    public void delete(Long id) {
        panierRepository.deleteById(id);
    }

    public void updateAfterPurchase(Long id){
        System.out.println("hello"+ id);
        panierRepository.updateAfterPurchase(id.intValue());

    }


}


//  findbyId      if (panierRepositoryModel.isEmpty()) {
//            return null;
//        } else {
//
//            return dvdStoreCartMapper.panierRepositoryToService2(panierRepositoryModel.get());
//
////            return new PanierServiceModel((panierRepositoryModel.get().getId()), panierRepositoryModel.get().getAmount(), panierRepositoryModel.get().getClientId(), panierRepositoryModel.get().getCreatedAt(), panierDvdServiceResponses );
//
//        }



//   save     PanierDvdRepositoryModel panierDvd = new PanierDvdRepositoryModel(panierDvdService.getDvdId(), null, panierDvdService.getId(), panierDvdService.getDvdSubtotal(), panierDvdService.getClientId() );



// by id //            for (PanierDvdRepositoryModel panierDvdRepositoryModel : panierRepositoryModel.get().getDvds()) {
////
////                PanierResponseServiceModel panierServiceModel = new PanierResponseServiceModel( Optional.ofNullable(panierDvdRepositoryModel.getPanier().getId()),panierDvdRepositoryModel.getPanier().getAmount(),panierDvdRepositoryModel.getPanier().getClientId(),panierDvdRepositoryModel.getPanier().getCreatedAt() );
////
////                PanierDvdServiceResponseModel panierDvd = new PanierDvdServiceResponseModel(panierDvdRepositoryModel.getDvdId(), panierServiceModel, panierDvdRepositoryModel.getId(), panierDvdRepositoryModel.getDvdSubtotal(), panierDvdRepositoryModel.getClientId() );
////
////                panierDvdServiceResponses.add(panierDvd);
////            }
