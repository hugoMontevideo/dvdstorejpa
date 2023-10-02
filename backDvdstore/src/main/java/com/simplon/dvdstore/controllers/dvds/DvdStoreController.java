package com.simplon.dvdstore.controllers.dvds;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import com.simplon.dvdstore.services.dvds.DvdStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController // donnees json ou xml
@RequestMapping("dvds")
public class DvdStoreController {

    @Autowired
    DvdStoreService dvdStoreService;

    @PostMapping     // insert
    public void add(  @RequestParam("name") String name,
                      @RequestParam("genre") String genre,
                      @RequestParam("quantite") int quantite,
                      @RequestParam("prix") Float prix,
                      @RequestPart("file") Optional<MultipartFile> file
                      ){
        if(!file.isEmpty()){
            if(dvdStoreService.uploadPicture(file.get())){
                dvdStoreService.add(new DvdServiceModel(name, genre,quantite,prix,file.get().getOriginalFilename()));
            };
        }

    }

    @GetMapping
    public ArrayList<DvdStoreGetDTO> findAll(){

        ArrayList<DvdStoreGetDTO> dvdStoreDTOSs = new ArrayList<>();

        ArrayList<DvdServiceModel> dvdServiceModels = dvdStoreService.findAll() ;

//        dvdServiceModels.forEach((item)->System.out.println(item.toString()));

        dvdServiceModels.forEach((item)->dvdStoreDTOSs.add(new DvdStoreGetDTO(item.getId().get(), item.getName(), item.getGenre(), item.getQuantite(), item.getPrix(), item.getPicture())) );

        return dvdStoreDTOSs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DvdStoreDTO> findById(@PathVariable Long id){


        try{
                DvdServiceModel dvdServiceModel =  dvdStoreService.findById(id);
//                DvdStoreDTO dvdStoreDTO = new DvdStoreDTO(dvdServiceModel.getName(),dvdServiceModel.getGenre(),dvdServiceModel.getQuantite(),dvdServiceModel.getPrix(),dvdServiceModel.getPicture());
                return new ResponseEntity<>(new DvdStoreDTO(dvdServiceModel.getName(),dvdServiceModel.getGenre(),dvdServiceModel.getQuantite(),dvdServiceModel.getPrix(),dvdServiceModel.getPicture()), HttpStatus.OK) ;

            }catch(DvdNotFoundException ex){

            System.out.println(ex.getReason());
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, ex.getReason() );

            }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateDvd(
            @PathVariable("id") Optional<Long> id,
            @RequestParam("name") String name,
            @RequestParam("genre") String genre,
            @RequestParam("quantite") int quantite,
            @RequestParam("prix") Float prix,
            @RequestParam("picture") String picture,
            @RequestPart("file") Optional<MultipartFile> file
    ){
        if (dvdStoreService.findById(  id.get() ) != null ){
            DvdServiceModel dvdServiceModel = new DvdServiceModel(id, name, genre, quantite, prix, picture);
            if(!file.isEmpty()){
                //  ***  TODO **** il faut effacer l'ancienne image  ****
                dvdStoreService.uploadPicture(file.get()); // charger l'image
                dvdServiceModel.setPicture(file.get().getOriginalFilename()); // mettre à jour le nom de picture
            }
            dvdStoreService.update( dvdServiceModel );

            return new ResponseEntity<>("Le dvd id : " + id +" a été modifié", HttpStatus.OK) ;
        }else{
            throw new DvdNotFoundException(HttpStatus.NOT_FOUND, "La ressource n'a pas été trouvé");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if(dvdStoreService.findById(id) != null ){
            dvdStoreService.delete(id);
            return new ResponseEntity<>("le dvd id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
         //  throw new NotFoundException(id);
            return new ResponseEntity<>("le dvd id : " + id + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public String deleteAll(){

            return dvdStoreService.deleteAll();

    }


}

//        if (dvdStoreService.findById(id ) != null ){
//            DvdServiceModel dvdServiceModel =  dvdStoreService.findById(id);
//            dvdStoreDTO.setName(dvdServiceModel.getName()) ;
//            dvdStoreDTO.setGenre(dvdServiceModel.getGenre());
//        return new ResponseEntity<>(dvdStoreDTO, HttpStatus.OK) ;
//        }else{
//        throw new DvdNotFoundException(id);
//        }
//    @PutMapping("/{id}")
//    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DvdStoreDTO dvdStoreDTO) throws DvdNotFoundException {
//
//        //        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();
//
//        if (dvdStoreService.findById(id ) != null ){
//            DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(id), dvdStoreDTO.getName(), dvdStoreDTO.getGenre(), dvdStoreDTO.getQuantite(), dvdStoreDTO.getPrix(), dvdStoreDTO.getPicture());
//            dvdStoreService.update(id, dvdServiceModel);
//
//            return new ResponseEntity<>("Le dvd id : " + id +" a été modifié", HttpStatus.OK) ;
//        }else{
//            throw new DvdNotFoundException(HttpStatus.NOT_FOUND, "La ressource n'a pas été trouvé");
//        }
//    }

//    @PostMapping  //
//    public boolean add(@RequestBody DvdStoreFileDTO dvdStoreFileDTO )
//    {
//        String fileName = dvdStoreFileDTO.getPicture().getOriginalFilename();// nom fichier téléchargé
//
//        dvdStoreService.uploadImage(dvdStoreFileDTO.getPicture());
//
//        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreFileDTO.getName(), dvdStoreFileDTO.getGenre(), dvdStoreFileDTO.getQuantite(), dvdStoreFileDTO.getPrix(), fileName);
//
//        return dvdStoreService.add(dvdServiceModel);
//    }

