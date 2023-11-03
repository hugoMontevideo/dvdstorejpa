package com.simplon.dvdstore.cart.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PanierRepository extends CrudRepository<PanierRepositoryModel, Long> {

    ArrayList<PanierRepositoryModel> findAll();

    @Query(value="CALL ps_update_after_purchase(:client_id)", nativeQuery = true)
    void updateAfterPurchase(Integer client_id);

}
