package com.simplon.dvdstore.cart.repositories;

import com.simplon.dvdstore.cart.controllers.PanierDvdInsertDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface PanierDvdRepository extends CrudRepository<PanierDvdRepositoryModel, Long> {

    ArrayList<PanierDvdRepositoryModel> findAll();


    @Query(value="CALL ps_calculate_totals2(:dvd_id,:panier_id,:dvd_quantite,:dvd_prix,:client_id)", nativeQuery = true)
    void savePanierDvd(Integer dvd_id, Integer panier_id, Integer dvd_quantite,Float dvd_prix, Integer client_id);

    @Query(value="CALL calculate2(:dvd_subtotal,:client_id)", nativeQuery = true)
    void saveTest2(Float dvd_subtotal, Integer client_id);

}
