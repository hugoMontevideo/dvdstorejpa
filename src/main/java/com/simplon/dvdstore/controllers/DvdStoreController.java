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
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.getName(), dvdStoreDTO.getGenre());
        return dvdStoreService.add(dvdServiceModel);

    }

    @GetMapping
    public ArrayList<DvdStoreGetDTO> findAll(){

        ArrayList<DvdStoreGetDTO> dvdStoreDTOSs = new ArrayList<>();

        ArrayList<DvdServiceModel> dvdServiceModels = dvdStoreService.findAll() ;

//        dvdServiceModels.forEach((item)->System.out.println(item.toString()));

        dvdServiceModels.forEach((item)->dvdStoreDTOSs.add(new DvdStoreGetDTO(item.getId().get(), item.getName(), item.getGenre())) );

        return dvdStoreDTOSs;
    }

    @GetMapping("/{id}")
    public DvdStoreDTO findById(@PathVariable Long id){
        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();

        if ( dvdStoreService.findById(id ) != null ){
            DvdServiceModel dvdServiceModel =  dvdStoreService.findById(id);
            dvdStoreDTO.setName(dvdServiceModel.getName()) ;
            dvdStoreDTO.setGenre(dvdServiceModel.getGenre());
        }

        return dvdStoreDTO ;



    }

}
