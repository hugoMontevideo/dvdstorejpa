package com.simplon.dvdstore.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DvdStoreRepository extends CrudRepository<DvdRepositoryModel,Long>{

   DvdRepositoryModel save(DvdRepositoryModel dvdRepositoryModel);
}
