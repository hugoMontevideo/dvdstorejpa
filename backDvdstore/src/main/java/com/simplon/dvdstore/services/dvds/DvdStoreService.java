package com.simplon.dvdstore.services.dvds;

import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;
import com.simplon.dvdstore.repositories.dvds.DvdStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DvdStoreService {

    @Autowired
    DvdStoreRepository dvdStoreRepository;

    public boolean add(DvdServiceModel dvdServiceModel){

        DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel( dvdServiceModel.getName(), dvdServiceModel.getGenre());
        DvdRepositoryModel dvdRepositoryModelReturn = dvdStoreRepository.save( dvdRepositoryModel);

        return dvdRepositoryModelReturn != null ;

    }

    public ArrayList<DvdServiceModel> findAll() {

        ArrayList<DvdServiceModel> dvdServiceModels = new ArrayList<>();

        ArrayList<DvdRepositoryModel> dvdRepositoryModels = dvdStoreRepository.findAll();

        //dvdRepositoryModels.forEach((item)->System.out.println(item.toString()));
        dvdRepositoryModels.forEach( (item)->dvdServiceModels.add(new DvdServiceModel( Optional.ofNullable(item.getId()), item.getName(), item.getGenre(), item.getQuantite(), item.getPrix(), item.getPicture())) );

        return dvdServiceModels;
    }

    public DvdServiceModel findById(Long id) {

        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if(dvdRepositoryModel.isEmpty())
        {
            return null;
        } else {
            return new DvdServiceModel(dvdRepositoryModel.get().getName(),dvdRepositoryModel.get().getGenre(), dvdRepositoryModel.get().getQuantite(), dvdRepositoryModel.get().getPrix(), dvdRepositoryModel.get().getPicture());
        }
    }

    public boolean update(Long id, DvdServiceModel dvdServiceModel) {

//        Optional<DvdRepositoryModel> dvdRepositoryModel = dvdStoreRepository.findById(id);

        if(!dvdStoreRepository.existsById(id))
        {
            return false;

        } else {
            DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel(id,dvdServiceModel.getName(),dvdServiceModel.getGenre(),dvdServiceModel.getQuantite(),dvdServiceModel.getPrix(), dvdServiceModel.getPicture());

            DvdRepositoryModel dvdRepositoryModelReturned = dvdStoreRepository.save( dvdRepositoryModel);

            return dvdRepositoryModelReturned != null ;
        }

    }

    public void delete(Long id) {
        dvdStoreRepository.deleteById(id);
    }

    public String deleteAll() {
        dvdStoreRepository.deleteAll();
        return "La bdd a été effacée.";
    }
}

//        if ( dvdStoreRepository.existsById(id) ){
//            DvdRepositoryModel dvdRepositoryModel = new DvdRepositoryModel();
//            dvdRepositoryModel = dvdStoreRepository.findById(id).get();
//            DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(dvdRepositoryModel.getId()), dvdRepositoryModel.getName(), dvdRepositoryModel.getGenre());
//            return dvdServiceModel;
//        }else{
//           DvdServiceModel dvdServiceModel = new DvdServiceModel();
//           return dvdServiceModel;
//}
