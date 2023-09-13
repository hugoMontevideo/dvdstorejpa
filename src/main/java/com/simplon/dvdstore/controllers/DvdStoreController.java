package com.simplon.dvdstore.controllers;


import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller


@RestController // donnees json ou xml
@RequestMapping("dvds")
public class DvdStoreController {

    @Autowired
    DvdStoreService dvdStoreService;

    @PostMapping  //
    public boolean add(@RequestBody DvdStoreDTO dvdStoreDTO )
    {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.name(), dvdStoreDTO.genre());
        return dvdStoreService.add(dvdServiceModel);

    }

    @GetMapping
    public ArrayList<DvdStoreDTO> getAll(){

        ArrayList<DvdStoreDTO> dvdStoreDTOSs = new ArrayList<>();

        ArrayList<DvdServiceModel> dvdServiceModels = dvdStoreService.getAll() ;

        dvdServiceModels.forEach((item)->System.out.println(item.toString()));

        dvdServiceModels.forEach((item)->dvdStoreDTOSs.add(new DvdStoreDTO(item.getName(), item.getGenre())) );

        return dvdStoreDTOSs;
    }

}
