package com.simplon.dvdstore.controllers.client;

import com.simplon.dvdstore.controllers.dvds.DvdStoreDTO;
import com.simplon.dvdstore.controllers.dvds.DvdStoreGetDTO;
import com.simplon.dvdstore.exceptions.DvdNotFoundException;
import com.simplon.dvdstore.services.client.ClientService;
import com.simplon.dvdstore.services.client.ClientServiceModel;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    ClientService clientService;

    @PostMapping
    public boolean add(@RequestBody ClientDTO clientDTO){
        ClientServiceModel clientServiceModel = new ClientServiceModel(clientDTO.getName(), clientDTO.getFirstname(), clientDTO.getEmail(), clientDTO.getAdresse());
        return clientService.add(clientServiceModel);

    }

    @GetMapping
    public ArrayList<ClientGetDTO> findAll(){

        ArrayList<ClientGetDTO> clientGetDTOS = new ArrayList<>();

        ArrayList<ClientServiceModel> clientServiceModels = clientService.findAll() ;

//        dvdServiceModels.forEach((item)->System.out.println(item.toString()));

        clientServiceModels.forEach((item)->clientGetDTOS.add(new ClientGetDTO(item.getId().get(), item.getName(), item.getFirstname(), item.getEmail(), item.getAdresse())) );

        return clientGetDTOS;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Long id){
        try{
            ClientServiceModel clientServiceModel =  clientService.findById(id);
            return new ResponseEntity<>(new ClientDTO(clientServiceModel.getName(),clientServiceModel.getFirstname(),clientServiceModel.getEmail(),clientServiceModel.getAdresse()), HttpStatus.OK) ;
        }catch(DvdNotFoundException ex){

            System.out.println(ex.getReason());
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, ex.getReason() );

        }
    }
}
