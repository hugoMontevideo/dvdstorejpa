package com.simplon.dvdstore.cart.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PanierRepository extends CrudRepository<PanierRepositoryModel, Long> {

    ArrayList<PanierRepositoryModel> findAll();


}
