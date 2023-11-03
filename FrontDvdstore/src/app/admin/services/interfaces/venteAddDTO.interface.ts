import { PanierDvdDTO } from "../../core/panier/panierDvdDTO.interface";

export interface VenteAddDTO{
    panierId: number;
    amount: number;
    clientId: number;
    dvds: Array<PanierDvdDTO>;
}