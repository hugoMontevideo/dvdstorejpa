package com.simplon.dvdstore.repositories.vente;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface VenteRepository extends CrudRepository<VenteRepositoryModel, Long> {

    ArrayList<VenteRepositoryModel> findAll();
}
