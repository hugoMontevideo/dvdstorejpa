package com.simplon.dvdstore.proxies;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdFeignBean;
import com.simplon.dvdstore.controllers.feignclient.PanierDvdInsertDTO;
import com.simplon.dvdstore.controllers.feignclient.PanierFeignBean;
import com.simplon.dvdstore.controllers.feignclient.PanierFeignCreate;
import com.simplon.dvdstore.controllers.vente.VenteAddDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@FeignClient(name="microservice-cart", url = "localhost:9000")
public interface MicroservicePanierProxy {
    @PostMapping("/clients/{id}/panier/panierdvd")
    PanierDvdFeignBean addPanierDvd(@PathVariable("id") Long id, @RequestBody PanierDvdInsertDTO panierDvd);

    @GetMapping("/clients/{id}/panier/{panier_id}")
    PanierFeignBean findById(@PathVariable("id") Long id, @PathVariable("panier_id") Long panierId);

    @GetMapping("/clients/panier")
    ArrayList<PanierFeignBean> findAll();

    @DeleteMapping("/clients/{id}/panier/panierdvd/{id_panierdvd}")
    PanierFeignBean deletePanierDvd(@PathVariable("id") Long id, @PathVariable("id_panierdvd") Long idPanierdvd);


    @PutMapping("/clients/{id}/purchase")
    void panierPurchased(@PathVariable("id") Long id);

    @GetMapping("/carts")
    String test ();
    @PostMapping("/carts/panier")
    String savePanier(PanierFeignCreate panier);

}



//    @PostMapping("/carts/panier")
//    String save(PanierFeignCreate panier);































