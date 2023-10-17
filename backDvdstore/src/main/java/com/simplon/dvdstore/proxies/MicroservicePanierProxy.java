package com.simplon.dvdstore.proxies;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdFeignBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient(name="microservice-cart", url = "localhost:9000")
public interface MicroservicePanierProxy {

    @GetMapping("/cart")
    String test ();


    @GetMapping("/cart/{id}")
    PanierDvdFeignBean findById(@PathVariable("id") Long id);

}
