package com.simplon.dvdstore.repositories.client;

import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface ClientRepository extends CrudRepository<ClientRepositoryModel, Long> {

    ArrayList<ClientRepositoryModel> findAll();
    
}
