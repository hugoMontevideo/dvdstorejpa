package com.simplon.dvdstore.cart.repositories;

import com.simplon.dvdstore.cart.controllers.PanierDvdInsertDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PanierDvdRepository extends CrudRepository<PanierDvdRepositoryModel, Long> {

    ArrayList<PanierDvdRepositoryModel> findAll();


    @Query(value="CALL ps_calculate_totals(:dvd_id,:panier_id,:quantite_dvd,:prix_dvd,:id_client)", nativeQuery = true)
    void savePanierDvd(Integer dvd_id, Integer panier_id, Integer quantite_dvd,Float prix_dvd, Integer id_client);




}
