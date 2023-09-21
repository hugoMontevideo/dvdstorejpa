package com.simplon.dvdstore.controllers.vente;

import com.simplon.dvdstore.repositories.dvds.DvdRepositoryModel;

public record VenteGetDTO (Long id, Long dateDeVente, Long dvdstore_id, int quantité, Long client_id, Float montant){}
