package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.controllers.client.ClientGetDTO;
import com.simplon.dvdstore.controllers.dvds.DvdStoreGetDTO;


public record VenteGetDTO (Long id, Long dateDeVente, DvdStoreGetDTO dvdStoreGetDTO, int quantite, ClientGetDTO clientGetDTO, Float montant){}
