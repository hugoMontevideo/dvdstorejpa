package com.simplon.dvdstore.controllers.feignclient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class PanierFeignCreate {

        private Float amount;
        private Long clientId;
        private Long createdAt;

}
