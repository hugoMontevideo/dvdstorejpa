package com.simplon.dvdstore.cart.services;

import com.simplon.dvdstore.cart.repositories.PanierDvdRepository;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PanierDvdService {

    @Autowired PanierDvdRepository panierDvdRepository;

    public PanierDvdServiceRequestModel findById(Long id) {

        Optional<PanierDvdRepositoryModel> panierDvdRepositoryModel = panierDvdRepository.findById(id);

        if(panierDvdRepositoryModel.isEmpty())
        {
            return null;
        } else {
//            return new PanierDvdServiceRequestModel(panierDvdRepositoryModel.get().getId(), panierDvdRepositoryModel.get().getDvdId(),panierDvdRepositoryModel.get().getPanierId(), panierDvdRepositoryModel.get().getDvdQuantite(), panierDvdRepositoryModel.get().getDvdPrix());
            // ** todo *******
            return new PanierDvdServiceRequestModel();
        }
    }

    public void savePanierDvd(PanierDvdServiceRequestModel panierDvdServiceRequestModel){
        panierDvdRepository.savePanierDvd(panierDvdServiceRequestModel.getDvdId().intValue(), panierDvdServiceRequestModel.getPanierId().intValue(), panierDvdServiceRequestModel.getDvdQuantite(), panierDvdServiceRequestModel.getDvdPrix(), panierDvdServiceRequestModel.getClientId().intValue() );

    }
}
