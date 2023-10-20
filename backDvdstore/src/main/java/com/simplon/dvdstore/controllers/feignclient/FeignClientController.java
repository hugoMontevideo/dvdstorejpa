package com.simplon.dvdstore.controllers.feignclient;

import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("cart")
public class FeignClientController {

    private final MicroservicePanierProxy panierProxy;

    @GetMapping("/{id}")
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
