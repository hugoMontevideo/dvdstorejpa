package com.simplon.dvdstore.cart.services;

import com.simplon.dvdstore.cart.controllers.PanierDTO;
import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepository;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repositories.PanierRepository;
import com.simplon.dvdstore.cart.repositories.PanierRepositoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PanierDvdService {

    @Autowired
    PanierDvdRepository panierDvdRepository;
    @Autowired
    PanierRepository panierRepository;
    private final DvdStoreCartMapper dvdStoreCartMapper = DvdStoreCartMapper.INSTANCE;

    public PanierDvdServiceResponseModel findById(Long id) {

        Optional<PanierDvdRepositoryModel> panierDvdRepositoryModel = panierDvdRepository.findById(id);

        if (panierDvdRepositoryModel.isEmpty()) {
            return null;
        } else {
            PanierDvdServiceResponseModel panierDvdServiceResponseModel = dvdStoreCartMapper.panierDvdRepositoryToService(panierDvdRepositoryModel.get());
            // insertion de l'objet panier dans panierdvd
            panierDvdServiceResponseModel.setPanier(dvdStoreCartMapper.panierRepositoryToService(panierDvdRepositoryModel.get().getPanier()));
            return panierDvdServiceResponseModel;
        }
    }

    public void savePanierDvd(PanierDvdServiceRequestModel panierDvdServiceRequestModel){

        panierDvdRepository.savePanierDvd(panierDvdServiceRequestModel.getDvdId().intValue(), panierDvdServiceRequestModel.getPanierId().intValue(), panierDvdServiceRequestModel.getDvdQuantite(), panierDvdServiceRequestModel.getDvdPrix(), panierDvdServiceRequestModel.getClientId().intValue() );
    }

    public void delete(Long id) {
        panierDvdRepository.deleteById(id);
    }


    public void insertIntoPanierDvd(PanierDvdServiceRequestModel panierDvdServiceRequestModel) {
        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(panierDvdServiceRequestModel.getPanierId());

        PanierDvdRepositoryModel panierDvdRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierDvdServiceRequestModel);

        panierDvdRepositoryModel.setPanier(panierRepositoryModel.get());

        panierDvdRepository.save(panierDvdRepositoryModel);



    }




}



//   panierDvdRepositoryModel.get().getPanier().getDvds().stream().map(
//           (value) -> dvdStoreCartMapper.panierRepositoryToService(value)
////                dvdStoreCartMapper::panierDvdRepositorytoService
//           ).collect(Collectors.toList());








