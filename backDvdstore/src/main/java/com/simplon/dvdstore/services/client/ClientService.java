package com.simplon.dvdstore.services.client;

import com.simplon.dvdstore.repositories.client.ClientRepository;
import com.simplon.dvdstore.repositories.client.ClientRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public boolean add(ClientServiceModel clientServiceModel) {
        ClientRepositoryModel clientRepositoryModel = new ClientRepositoryModel(clientServiceModel.getName(), clientServiceModel.getFirstname(), clientServiceModel.getEmail(), clientServiceModel.getAdresse());

        ClientRepositoryModel clientRepositoryReturned = clientRepository.save(clientRepositoryModel);

        return clientRepositoryReturned != null;
    }

    public ArrayList<ClientServiceModel> findAll() {

        ArrayList<ClientServiceModel> clientServiceModels = new ArrayList<>();

        ArrayList<ClientRepositoryModel> clientRepositoryModels = clientRepository.findAll();

        //dvdRepositoryModels.forEach((item)->System.out.println(item.toString()));
        clientRepositoryModels.forEach( (item)->clientServiceModels.add(new ClientServiceModel( Optional.ofNullable(item.getId()), item.getName(), item.getFirstname(), item.getEmail(), item.getAdresse())) );

        return clientServiceModels;
    }

    public ClientServiceModel findById(Long id){
        Optional<ClientRepositoryModel> clientRepositoryModel = clientRepository.findById(id);

        if(clientRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return new ClientServiceModel(clientRepositoryModel.get().getFirstname(),clientRepositoryModel.get().getName(), clientRepositoryModel.get().getEmail(), clientRepositoryModel.get().getAdresse());
        }


    }


}
