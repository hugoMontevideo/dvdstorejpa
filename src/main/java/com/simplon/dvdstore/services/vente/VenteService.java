package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdStoreRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    DvdStoreRepository dvdStoreRepository;

    public boolean add(VenteServiceModel venteServiceModel) {

        DvdRepositoryModel dvdRepositoryModel = dvdStoreRepository.findById(venteServiceModel.getDvdstore_id()).get();
        ClientRepositoryModel clientRepositoryModel = clientRepository.findById(venteServiceModel.getClient_id()).get();

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel( dvdRepositoryModel, venteServiceModel.getQuantite(), clientRepositoryModel );

//        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel( venteServiceModel.getQuantite());

        VenteRepositoryModel venteRepositoryReturned = venteRepository.save(venteRepositoryModel);

        return venteRepositoryReturned != null ;
    }
}
