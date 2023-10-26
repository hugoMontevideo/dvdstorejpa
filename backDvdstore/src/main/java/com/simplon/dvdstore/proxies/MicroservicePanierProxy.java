package com.simplon.dvdstore.proxies;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdFeignBean;
import com.simplon.dvdstore.controllers.feignclient.PanierFeignBean;
import com.simplon.dvdstore.controllers.feignclient.PanierFeignCreate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;


@FeignClient(name="microservice-cart", url = "localhost:9000")
public interface MicroservicePanierProxy {

    @GetMapping("/carts")
    String test ();
    @PostMapping("/carts/panier")
    String savePanier(PanierFeignCreate panier);
    @GetMapping("/carts/panier/{id}")
    PanierFeignBean findById(@PathVariable("id") Long id);

    @GetMapping("/carts/panier")
    ArrayList<PanierFeignBean> findAll();

    @DeleteMapping("/carts/panierdvd/{id}")
    PanierFeignBean deletePanierDvd(@PathVariable("id") Long id);
    @PostMapping("/carts/panier")
    String save(PanierFeignCreate panier);
}


































