package com.simplon.dvdstore.repositories.vente;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface DetailVenteRepository extends CrudRepository<DetailVenteRepositoryModel, Long> {
    ArrayList<DetailVenteRepositoryModel> findAll();
}
