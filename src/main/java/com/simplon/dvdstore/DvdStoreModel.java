package com.simplon.dvdstore;


import com.simplon.dvdstore.repositories.DvdRepositoryModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DvdStoreModel {

    List<DvdRepositoryModel> dvds = new ArrayList<>();
}
