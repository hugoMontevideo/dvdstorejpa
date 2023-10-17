package com.simplon.dvdstore.controllers.feignclient;

import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@AllArgsConstructor
@RestController
public class FeignClientController {

    private final MicroservicePanierProxy panierProxy;

    @RequestMapping(value="/{id}")
    PanierDvdFeignBean test(@PathVariable("id") Long id)
    {
        PanierDvdFeignBean panierDvdFeignBean =  panierProxy.findById(id);
        return panierDvdFeignBean;
    }

}

//    PanierDvdFeignBean findById()
//    {
//        System.out.println("soutfeing");
//        return panierProxy.findById(2);
//    }
