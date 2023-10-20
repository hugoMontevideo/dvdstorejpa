package com.simplon.dvdstore.cart.services;

import com.simplon.dvdstore.cart.controllers.PanierGetDTO;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repositories.PanierRepository;
import com.simplon.dvdstore.cart.repositories.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PanierService {
    @Autowired
    PanierRepository panierRepository;

    public boolean save(PanierServiceModel panierServiceModel) {

        ArrayList<PanierDvdRepositoryModel>  panierDvdRepositoryModels = new ArrayList<>();

        for (PanierDvdServiceResponseModel panierDvdService : panierServiceModel.getDvds()) {

//            PanierDvdRepositoryModel panierDvd = new PanierDvdRepositoryModel(panierDvdService.getDvdId(), null, panierDvdService.getId(), panierDvdService.getDvdSubtotal(), panierDvdService.getClientId() );

            PanierDvdRepositoryModel panierDvd = new PanierDvdRepositoryModel( );

            panierDvdRepositoryModels.add(panierDvd);
        }

        PanierRepositoryModel panierRepositoryModel = new PanierRepositoryModel(
               0L,
                panierServiceModel.getAmount(),
                panierServiceModel.getClientId(),
                panierServiceModel.getCreatedAt(),
                panierDvdRepositoryModels);

        PanierRepositoryModel panierRepositoryModelReturn = panierRepository.save(panierRepositoryModel);

        return panierServiceModel != null;
    }

    public PanierServiceModel findById(Long id) {
        ArrayList<PanierDvdServiceResponseModel>  panierDvdServiceResponses = new ArrayList<>();

        System.out.println(panierDvdServiceResponses.toString());

        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(id);


        if (panierRepositoryModel.isEmpty()) {
            return null;
        } else {

//            for (PanierDvdRepositoryModel panierDvdRepositoryModel : panierRepositoryModel.get().getDvds()) {
//
//                PanierResponseServiceModel panierServiceModel = new PanierResponseServiceModel( Optional.ofNullable(panierDvdRepositoryModel.getPanier().getId()),panierDvdRepositoryModel.getPanier().getAmount(),panierDvdRepositoryModel.getPanier().getClientId(),panierDvdRepositoryModel.getPanier().getCreatedAt() );
//
//                PanierDvdServiceResponseModel panierDvd = new PanierDvdServiceResponseModel(panierDvdRepositoryModel.getDvdId(), panierServiceModel, panierDvdRepositoryModel.getId(), panierDvdRepositoryModel.getDvdSubtotal(), panierDvdRepositoryModel.getClientId() );
//
//                panierDvdServiceResponses.add(panierDvd);
//            }
            return new PanierServiceModel((panierRepositoryModel.get().getId()), panierRepositoryModel.get().getAmount(), panierRepositoryModel.get().getClientId(), panierRepositoryModel.get().getCreatedAt(), panierDvdServiceResponses );

        }
    }

    public void delete(Long id) {
        panierRepository.deleteById(id);
    }

}
