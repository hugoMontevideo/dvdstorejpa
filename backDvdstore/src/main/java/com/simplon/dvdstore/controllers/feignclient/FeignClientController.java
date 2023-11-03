package com.simplon.dvdstore.controllers.feignclient;

import com.simplon.dvdstore.controllers.vente.VenteAddDTO;
import com.simplon.dvdstore.mappers.DvdStoreMapper;
import com.simplon.dvdstore.proxies.MicroservicePanierProxy;
import com.simplon.dvdstore.services.dvds.DvdServiceModel;
import com.simplon.dvdstore.services.dvds.DvdStoreService;
import com.simplon.dvdstore.services.vente.DetailVenteServiceRequestModel;
import com.simplon.dvdstore.services.vente.VenteService;
import com.simplon.dvdstore.services.vente.VenteServiceRequestModel;
import com.simplon.dvdstore.services.vente.VenteServiceResponseModel;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping
public class FeignClientController {

    private final MicroservicePanierProxy panierProxy;
    @Autowired
    DvdStoreService dvdStoreService;
    @Autowired
    VenteService venteService;
    private final DvdStoreMapper dvdStoreMapper = DvdStoreMapper.INSTANCE;

    @PostMapping("/clients/{id}/purchase")
    public void panierPurchased(@PathVariable Long id, @RequestBody VenteAddDTO venteAddDTO){
        VenteServiceRequestModel venteServiceRequestModel = new VenteServiceRequestModel(
            venteAddDTO.getAmount(), venteAddDTO.getClientId(), 0L
        );
        VenteServiceResponseModel venteServiceResponseModel = venteService.add(venteServiceRequestModel);

        //mappage et ajout de l'objet vente aux Details vente
        ArrayList<DetailVenteServiceRequestModel> detailVenteRequestModels = new ArrayList<>();
        for ( PanierDvdInsertDTO item:  venteAddDTO.getDvds()) {
            DetailVenteServiceRequestModel detailVenteRequestModel = new DetailVenteServiceRequestModel(
                    item.getDvdId(),
                    venteServiceResponseModel,
                    item.getDvdSubtotal(),
                    item.getClientId(),
                    item.getDvdQuantite()
            );
            detailVenteRequestModels.add(detailVenteRequestModel);
        }

        venteService.addDetailVentes(detailVenteRequestModels);

        panierProxy.panierPurchased(id);

    };

    @GetMapping("/clients/{id}/panier/{panier_id}")  //  final version ***
    PanierFeignBean panierById(@PathVariable("id") Long id, @PathVariable("panier_id") Long panierId )
    {
        PanierFeignBean panierFeignBean =  panierProxy.findById(id,panierId);

        ArrayList<PanierDvdFeignBean> panierDvdFeignBeans = new ArrayList<>();

        for ( PanierDvdFeignBean item : panierFeignBean.getDvds() ){
            // rajouter le nom des dvds au tableau pour affichage
            DvdServiceModel dvdServiceModel =  dvdStoreService.findById(item.getDvdId());
            item.setNameDvd(Optional.ofNullable(dvdServiceModel.getName()));
            panierDvdFeignBeans.add(item);
        };
        return panierFeignBean;
    }

    @GetMapping("/panier")
    ArrayList<PanierFeignBean> findAll(){
        ArrayList<PanierFeignBean> panierFeignBeans = panierProxy.findAll();

        return panierFeignBeans;
    }

    @PostMapping("clients/{id}/panier/panierdvd")   //  final version  *****
    PanierDvdFeignBean addPanierDvd(@RequestBody PanierDvdInsertDTO panierDvd){

        // enlever quantité commandée du stock
        DvdServiceModel dvd =  dvdStoreService.findById(panierDvd.getDvdId());
        dvd.setQuantite( dvd.getQuantite() - panierDvd.getDvdQuantite() );
        dvdStoreService.update(dvd);


      return panierProxy.addPanierDvd(panierDvd.getClientId(), panierDvd);

    }

    @DeleteMapping("/clients/{id}/panier/panierdvd/{id_panierdvd}")   //  todo ***   manage error 500
    ResponseEntity<String> deletePanierDvd(@PathVariable("id") Long id, @PathVariable("id_panierdvd") Long idPanierdvd, HttpServletRequest request){
        // rajouter quantité commandée au stock
            // todo *** manage try catch
        String headerDvdId = request.getHeader("Header-dvd-id");
        String headerDvdQuantite = request.getHeader("Header-dvd-quantite");
        DvdServiceModel dvd =  dvdStoreService.findById(Long.valueOf(headerDvdId));
        dvd.setQuantite( dvd.getQuantite() + Integer.parseInt(headerDvdQuantite) );
        dvdStoreService.update(dvd);

        panierProxy.deletePanierDvd(id, idPanierdvd);

        return new ResponseEntity<>("panierDvd supprimé."+ idPanierdvd, HttpStatus.OK);
    }

}

//    PanierDvdFeignBean findById()
//    {
//        System.out.println("soutfeing");
//        return panierProxy.findById(2);
//    }

//    @PostMapping("/panier")
//    ResponseEntity<String> addPanier(@RequestBody PanierFeignCreate panier){
//        System.out.println("hello");
//        System.out.println(panier);
//
//        panierProxy.save(panier);
//
//        return new ResponseEntity<>("panierDvd crée.", HttpStatus.OK);
//    }
