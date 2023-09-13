package com.simplon.dvdstore.services;

import com.simplon.dvdstore.controllers.DvdStoreDTO;
import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdModelRepository;


    public boolean add(DvdServiceModel dvdServiceModel){

        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel( dvdServiceModel.getName(), dvdServiceModel.getGenre());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdModelRepository.save( dvdRepositoryModel);

        return dvdRepositoryModelReturned != null ;

    }

    public ArrayList<DvdServiceModel> getAll() {

        ArrayList<DvdServiceModel> dvdServiceModels = new ArrayList<>();

        ArrayList<DvdRepositoryModel> dvdRepositoryModels = dvdModelRepository.findAll();
        dvdRepositoryModels.forEach((item)->System.out.println(item.toString()));
        dvdRepositoryModels.forEach( (item)->dvdServiceModels.add(new DvdServiceModel(item.getName(), item.getGenre())) );

        return dvdServiceModels;
    }
}

