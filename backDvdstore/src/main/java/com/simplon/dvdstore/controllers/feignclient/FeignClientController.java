package com.simplon.dvdstore.controllers.feignclient;

import com.simplon.dvdstore.controllers.dvds.DvdStoreGetDTO;
import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("carts")
public class FeignClientController {

    private final MicroservicePanierProxy panierProxy;

    @GetMapping("/panier/{id}")
    PanierFeignBean panierById(@PathVariable("id") Long id)
    {
        PanierFeignBean panierFeignBean =  panierProxy.findById(id);

        return panierFeignBean;
    }

    @GetMapping("/panier")
    ArrayList<PanierFeignBean> findAll(){
        ArrayList<PanierFeignBean> panierFeignBeans = panierProxy.findAll();

        return panierFeignBeans;
    }

    @DeleteMapping("/panierdvd/{id}")
    ResponseEntity<String> deletePanierDvd(@PathVariable("id") Long id){
        System.out.println("hello");
        panierProxy.deletePanierDvd(id);

        return new ResponseEntity<>("panierDvd supprimé.", HttpStatus.OK);
    }

}

//    PanierDvdFeignBean findById()
//    {
//        System.out.println("soutfeing");
//        return panierProxy.findById(2);
//    }
