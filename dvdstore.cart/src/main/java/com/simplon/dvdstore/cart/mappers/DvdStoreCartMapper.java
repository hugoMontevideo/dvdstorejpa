package com.simplon.dvdstore.cart.mappers;

import com.simplon.dvdstore.cart.controllers.PanierDvdInsertDTO;
import com.simplon.dvdstore.cart.controllers.PanierDvdResponseDTO;
import com.simplon.dvdstore.cart.controllers.PanierResponseDTO;
import com.simplon.dvdstore.cart.repositories.PanierDvdRepositoryModel;
import com.simplon.dvdstore.cart.repositories.PanierRepositoryModel;
import com.simplon.dvdstore.cart.services.PanierDisplayServiceModel;
import com.simplon.dvdstore.cart.services.PanierDvdServiceRequestModel;
import com.simplon.dvdstore.cart.services.PanierDvdServiceResponseModel;
import com.simplon.dvdstore.cart.services.PanierServiceModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Optional;

@Mapper
public interface DvdStoreCartMapper {

    DvdStoreCartMapper INSTANCE = Mappers.getMapper(DvdStoreCartMapper.class);

// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//            DTO  ->  Service  -->  Repository
// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    PanierDvdServiceRequestModel insertDtoToServiceRequest(PanierDvdInsertDTO panierDvdInsertDTO);
    @Mapping(target = "panier", ignore = true)
    PanierDvdRepositoryModel serviceToRepository(PanierDvdServiceRequestModel panierDvdServiceRequestModel);



    // ------------------------------------------------------------------------------
    //             List<Repository>  ->  List<Service>  -->  List<GetDTO>
    // ------------------------------------------------------------------------------
    //ArrayList<PanierDvdServiceModel> arrayListRepositoryToService(Iterable<PanierDvdRepositoryModel> paniers);
    //
    //    ArrayList<PanierDvdGetDTO> arrayListServiceToDTO(ArrayList<PanierDvdServiceModel> paniers);


    // ------------------------------------------------------------------------------
    //             Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------
    @Mapping(target = "dvds", ignore = true)
    PanierServiceModel panierRepositoryToService(PanierRepositoryModel panierRepositoryModel);

    PanierServiceModel panierRepositoryToService2(PanierRepositoryModel panierRepositoryModel);


    PanierResponseDTO panierServiceToDTO(PanierServiceModel panierServiceModel);




    @Mapping(target = "panier", ignore = true)
    PanierDvdServiceResponseModel panierDvdRepositoryToService(PanierDvdRepositoryModel panierDvdRepositoryModel );

    PanierDvdResponseDTO panierDvdServiceToDto(PanierDvdServiceResponseModel panierDvdServiceResponseModel );



}
