package com.simplon.dvdstore;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class DvdStoreModel {

    List<DvdModel> dvds = new ArrayList<>();
}
