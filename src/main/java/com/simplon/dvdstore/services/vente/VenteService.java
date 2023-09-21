package com.simplon.dvdstore.services.vente;

import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdStoreRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepository;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;


@Service
public class VenteService {

    @Autowired
    VenteRepository venteRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    DvdStoreRepository dvdStoreRepository;

    public boolean add(VenteServiceModel venteServiceModel) {

        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(venteServiceModel.getDvdServiceModel().getId().get() );
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(venteServiceModel.getClientServiceModel().getId().get());

        VenteRepositoryModel venteRepositoryModel = new VenteRepositoryModel( dvdRepositoryModel.get(), venteServiceModel.getQuantite(), clientRepositoryModel.get() );

        VenteRepositoryModel venteRepositoryReturned = venteRepository.save(venteRepositoryModel);

        return venteRepositoryReturned != null ;
    }

    public ArrayList<VenteServiceModel> findAll(){
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();

        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();

        venteRepositoryModels.forEach( (item)->{
            DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(item.getDvdRepositoryModel().getId()),item.getDvdRepositoryModel().getGenre(), item.getDvdRepositoryModel().getName(), item.getDvdRepositoryModel().getQuantite());

            ClientServiceModel clientServiceModel = new ClientServiceModel(Optional.ofNullable(item.getClientRepositoryModel().getId()),item.getClientRepositoryModel().getFirstname(), item.getClientRepositoryModel().getName(), item.getClientRepositoryModel().getEmail(), item.getClientRepositoryModel().getAdresse());

            venteServiceModels.add(new VenteServiceModel( Optional.ofNullable(item.getId()), item.getDateDeVente(), dvdServiceModel, item.getQuantite(), clientServiceModel, item.getMontant()));
        } );
        return venteServiceModels;
    }


    public ArrayList<VenteServiceModel> findAllById(Long id) {
        ArrayList<VenteServiceModel> venteServiceModels = new ArrayList<>();
        ArrayList<VenteRepositoryModel> venteRepositoryModels = venteRepository.findAll();

        for (VenteRepositoryModel item : venteRepositoryModels) {
            if(Objects.equals(item.getClientRepositoryModel().getId(), id)){
                DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(item.getDvdRepositoryModel().getId()),item.getDvdRepositoryModel().getGenre(), item.getDvdRepositoryModel().getName(), item.getDvdRepositoryModel().getQuantite());

                ClientServiceModel clientServiceModel = new ClientServiceModel(Optional.ofNullable(item.getClientRepositoryModel().getId()),item.getClientRepositoryModel().getFirstname(), item.getClientRepositoryModel().getName(), item.getClientRepositoryModel().getEmail(), item.getClientRepositoryModel().getAdresse());

                venteServiceModels.add(new VenteServiceModel( Optional.ofNullable(item.getId()), item.getDateDeVente(), dvdServiceModel, item.getQuantite(), clientServiceModel, item.getMontant()));
                System.out.println(item.toString());
            }
        };
//
//
//        };
//        for (VenteGetDTO x : venteGetDTOS) {
//        if(Objects.equals(x.get, "Dupont")){
//            System.out.println(x.toString());
//        }

        return venteServiceModels;
    }
}
