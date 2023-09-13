package com.simplon.dvdstore.services;

import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdModelRepository;


    public boolean add(DvdServiceModel dvdServiceModel){

        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel( dvdServiceModel.getName(), dvdServiceModel.getGenre());
        DvdRepositoryModel dvdRepositoryModelReturned = dvdModelRepository.save( dvdRepositoryModel);

        return dvdRepositoryModelReturned != null ;

    }

}

