package com.simplon.dvdstore.controllers.dvds;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DvdStoreFileDTO {
        private String name;
        private String genre;
        private int quantite;
        private Float prix;
        private MultipartFile picture;
}
