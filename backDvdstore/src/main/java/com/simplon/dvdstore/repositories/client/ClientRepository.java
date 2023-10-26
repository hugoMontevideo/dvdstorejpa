package com.simplon.dvdstore.repositories.client;

import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ClientRepository extends CrudRepository<ClientRepositoryModel, Long> {

    ArrayList<ClientRepositoryModel> findAll();

    @Query(value="SELECT v FROM ClientRepositoryModel", nativeQuery = true)
    Optional<ClientRepositoryModel> findByName ();
    
}
