package com.simplon.dvdstore.controllers;


import com.fasterxml.jackson.databind.util.JSONPObject;
import com.simplon.dvdstore.exceptions.NotFoundException;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.services.DvdServiceModel;
import com.simplon.dvdstore.services.DvdStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<DvdStoreDTO> findById(@PathVariable Long id) throws NotFoundException {
        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();

        if (dvdStoreService.findById(id ) != null ){
            DvdServiceModel dvdServiceModel =  dvdStoreService.findById(id);
            dvdStoreDTO.setName(dvdServiceModel.getName()) ;
            dvdStoreDTO.setGenre(dvdServiceModel.getGenre());
        return new ResponseEntity<>(dvdStoreDTO, HttpStatus.OK) ;
        }else{
            throw new NotFoundException(id);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DvdStoreDTO dvdStoreDTO) throws NotFoundException {

        //        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();

        if (dvdStoreService.findById(id ) != null ){
            DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(id), dvdStoreDTO.getName(), dvdStoreDTO.getGenre());
            dvdStoreService.update(id, dvdServiceModel);

            return new ResponseEntity<>("Le dvd id : " + id +" a été modifié", HttpStatus.OK) ;
        }else{
            throw new NotFoundException(id);
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws NotFoundException{
        if(dvdStoreService.findById(id) != null ){
            dvdStoreService.delete(id);
            return new ResponseEntity<>("le dvd id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
            throw new NotFoundException(id);
        }
    }







}
