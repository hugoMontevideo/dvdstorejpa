package com.simplon.dvdstore.proxies;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdFeignBean;
import com.simplon.dvdstore.controllers.feignclient.PanierFeignBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@FeignClient(name="microservice-cart", url = "localhost:9000")
public interface MicroservicePanierProxy {

    @GetMapping("/carts")
    String test ();


    @GetMapping("/carts/panier/{id}")
    PanierFeignBean findById(@PathVariable("id") Long id);

    @GetMapping("/carts/panier")
    ArrayList<PanierFeignBean> findAll();

    @DeleteMapping("/carts/panierdvd/{id}")
    PanierFeignBean deletePanierDvd(@PathVariable("id") Long id);

}


































