package com.simplon.dvdstore.repositories.dvds;

import org.springframework.data.repository.CrudRepository;
import java.util.ArrayList;

public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel,Long>{

//   DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
    ArrayList<DvdRepositoryModel> findAll();




}
