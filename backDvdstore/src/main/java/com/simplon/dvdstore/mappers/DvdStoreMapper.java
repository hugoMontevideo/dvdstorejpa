package com.simplon.dvdstore.mappers;

import com.simplon.dvdstore.controllers.feignclient.PanierDvdInsertDTO;
import com.simplon.dvdstore.repositories.vente.DetailVenteRepositoryModel;
import com.simplon.dvdstore.repositories.vente.VenteRepositoryModel;
import com.simplon.dvdstore.services.vente.DetailVenteServiceRequestModel;
import com.simplon.dvdstore.services.vente.DetailVenteServiceModel;
import com.simplon.dvdstore.services.vente.VenteServiceRequestModel;
import com.simplon.dvdstore.services.vente.VenteServiceResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DvdStoreMapper {
    DvdStoreMapper INSTANCE = Mappers.getMapper(DvdStoreMapper.class);
    // ------------------------------------------------------------------------------
    //             List<DTO>  ->  List<Service>  -->  List<Repo>
    // ------------------------------------------------------------------------------
      DetailVenteServiceModel panierDvdInsertDTOtoVenteService(PanierDvdInsertDTO panier);

      List<DetailVenteServiceModel> mapToVenteServiceList(List<PanierDvdInsertDTO> panierDvdInsertDTOS);

    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    //            DTO  ->  Service  -->  Repository
    // +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    @Mapping(target = "vente", ignore = true)
    DetailVenteRepositoryModel detailVenteRequestToRepositoryModel(DetailVenteServiceRequestModel detailVenteRequestModel);

    @Mapping(target = "dvds", ignore = true)
    VenteRepositoryModel venteServiceResponseToRepositoryModel(VenteServiceResponseModel venteServiceResponseModel);

    // ------------------------------------------------------------------------------
    //             List<Repo>  ->  List<Service>  -->  List<DTO>
    // ------------------------------------------------------------------------------

    //ArrayList<PanierDvdServiceModel> arrayListRepositoryToService(Iterable<PanierDvdRepositoryModel> paniers);
    //
    //    ArrayList<PanierDvdGetDTO> arrayListServiceToDTO(ArrayList<PanierDvdServiceModel> paniers);


    // ------------------------------------------------------------------------------
    //             Repository  ->  Service  -->  GetDTO
    // ------------------------------------------------------------------------------

    VenteServiceResponseModel venteRepositoryToResponseModel(VenteRepositoryModel venteRepositoryResponse );

    @Mapping(target = "dvds", ignore = true)
    VenteRepositoryModel venteServiceRequestModelToRepository(VenteServiceRequestModel venteServiceRequestModel);



}
