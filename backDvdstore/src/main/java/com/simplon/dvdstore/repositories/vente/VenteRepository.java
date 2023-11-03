package com.simplon.dvdstore.repositories.vente;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.ArrayList;

public interface VenteRepository extends CrudRepository<VenteRepositoryModel, Long> {

    ArrayList<VenteRepositoryModel> findAll();




}

//    @Query("SELECT v FROM VenteRepositoryModel v WHERE v.clientRepositoryModel.id=:id")
//    ArrayList<VenteRepositoryModel> findAllByClient(Long id);