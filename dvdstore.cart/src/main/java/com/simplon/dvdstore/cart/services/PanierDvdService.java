package com.simplon.dvdstore.cart.services;

import com.simplon.dvdstore.cart.controllers.PanierDTO;
import com.simplon.dvdstore.cart.mappers.DvdStoreCartMapper;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepository;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repositories.PanierRepository;
import com.simplon.dvdstore.cart.repositories.PanierRepositoryModel;
import jakarta.transaction.Transactional;
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

    @Transactional
    public PanierDvdServiceResponseModel findById(Long id) {
        Optional<PanierDvdRepositoryModel> panierDvdRepositoryModel = panierDvdRepository.findById(id);
        System.out.println(panierDvdRepositoryModel.get().getPanier().getDvds());
        if (panierDvdRepositoryModel.isEmpty()) {
            return null;
        } else {
            PanierDvdServiceResponseModel panierDvdServiceResponseModel = dvdStoreCartMapper.panierDvdRepositoryToService(panierDvdRepositoryModel.get());
            // insertion de l'objet panier dans panierdvd
            panierDvdServiceResponseModel.setPanier(dvdStoreCartMapper.panierRepositoryToService(panierDvdRepositoryModel.get().getPanier()));
            return panierDvdServiceResponseModel;
        }
    }

    public void insertIntoPanierDvd(PanierDvdServiceRequestModel   panierDvdServiceRequestModel) {     //  final version   *******
        // get panier object
        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(panierDvdServiceRequestModel.getPanierId());

        PanierDvdRepositoryModel panierDvdRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierDvdServiceRequestModel);

        panierDvdRepositoryModel.setPanier(panierRepositoryModel.get());

       panierDvdRepository.savePanierDvd(
               panierDvdRepositoryModel.getDvdId().intValue(),
               panierDvdRepositoryModel.getPanier().getId().intValue(),
               panierDvdRepositoryModel.getDvdQuantite(),
               panierDvdRepositoryModel.getDvdSubtotal(),
               panierDvdRepositoryModel.getClientId().intValue()
               );


    }

    public void delete(Long idPanierdvd, Long id) {
        panierDvdRepository.deletePanierDvd(idPanierdvd.intValue(), id.intValue());
    }




}



//   panierDvdRepositoryModel.get().getPanier().getDvds().stream().map(
//           (value) -> dvdStoreCartMapper.panierRepositoryToService(value)
////                dvdStoreCartMapper::panierDvdRepositorytoService
//           ).collect(Collectors.toList());

//    public void savePanierDvd(PanierDvdServiceRequestModel panierDvdServiceRequestModel){
//
//        panierDvdRepository.savePanierDvd(panierDvdServiceRequestModel.getDvdId().intValue(), panierDvdServiceRequestModel.getPanierId().intValue(), panierDvdServiceRequestModel.getDvdQuantite(), panierDvdServiceRequestModel.getDvdPrix(), panierDvdServiceRequestModel.getClientId().intValue() );
//    }



//    public PanierDvdServiceResponseModel insertIntoPanierDvd(PanierDvdServiceRequestModel   panierDvdServiceRequestModel) {     //  final version   *******
//        // get panier object
//        Optional<PanierRepositoryModel> panierRepositoryModel = panierRepository.findById(panierDvdServiceRequestModel.getPanierId());
//
//        PanierDvdRepositoryModel panierDvdRepositoryModel = dvdStoreCartMapper.serviceToRepository(panierDvdServiceRequestModel);
//
//        panierDvdRepositoryModel.setPanier(panierRepositoryModel.get());
//
//        PanierDvdRepositoryModel panierDvd =  panierDvdRepository.save(panierDvdRepositoryModel);
//
//        if(panierDvd != null ){
//            // update amount in panier  (stocked procedure)
//        }
//
//        PanierDvdServiceResponseModel panierDvdServiceResponseModel = dvdStoreCartMapper.panierDvdRepositoryToService(panierDvd);
//
//        // insertion de l'objet panier dans panierdvd
//        panierDvdServiceResponseModel.setPanier(dvdStoreCartMapper.panierRepositoryToService(panierDvd.getPanier()));
//
//        return panierDvdServiceResponseModel;
//
//    }


