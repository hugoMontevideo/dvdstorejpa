package com.simplon.dvdstore.controllers.dvds;

import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import com.simplon.dvdstore.services.dvds.DvdStoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin
@RestController // donnees json ou xml
@RequestMapping("dvds")
public class DvdStoreController {

    @Autowired
    DvdStoreService dvdStoreService;

    @PostMapping  //
    public boolean add(@RequestBody DvdStoreDTO dvdStoreDTO )
    {
        DvdServiceModel dvdServiceModel = new DvdServiceModel(dvdStoreDTO.getName(), dvdStoreDTO.getGenre(), dvdStoreDTO.getQuantite(), dvdStoreDTO.getPrix(), dvdStoreDTO.getPicture());

        return dvdStoreService.add(dvdServiceModel);

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

        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();

        try{
                DvdServiceModel dvdServiceModel =  dvdStoreService.findById(id);
                dvdStoreDTO.setName(dvdServiceModel.getName()) ;
                dvdStoreDTO.setGenre(dvdServiceModel.getGenre());
                return new ResponseEntity<>(dvdStoreDTO, HttpStatus.OK) ;

            }catch(DvdNotFoundException ex){

            System.out.println(ex.getReason());
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, ex.getReason() );

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


    @PutMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable Long id, @RequestBody DvdStoreDTO dvdStoreDTO) throws DvdNotFoundException {

        //        DvdStoreDTO dvdStoreDTO = new DvdStoreDTO();

        if (dvdStoreService.findById(id ) != null ){
            DvdServiceModel dvdServiceModel = new DvdServiceModel(Optional.ofNullable(id), dvdStoreDTO.getName(), dvdStoreDTO.getGenre(), dvdStoreDTO.getQuantite(), dvdStoreDTO.getPrix(), dvdStoreDTO.getPicture());
            dvdStoreService.update(id, dvdServiceModel);

            return new ResponseEntity<>("Le dvd id : " + id +" a été modifié", HttpStatus.OK) ;
        }else{
            throw new DvdNotFoundException(HttpStatus.NOT_FOUND, "La ressource n'a pas été trouvé");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) throws DvdNotFoundException{
        if(dvdStoreService.findById(id) != null ){
            dvdStoreService.delete(id);
            return new ResponseEntity<>("le dvd id : " + id + " a été supprimé", HttpStatus.OK);
        }else{
//            throw new NotFoundException(id);
            return new ResponseEntity<>("le dvd id : " + id + " n'a pas été trouvé", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping
    public String deleteAll(){

            return dvdStoreService.deleteAll();

    }


}
