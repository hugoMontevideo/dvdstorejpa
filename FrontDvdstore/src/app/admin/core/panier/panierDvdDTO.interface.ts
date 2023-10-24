import { PanierDTO } from "./panierDTO.interface"

export interface PanierDvdDTO{
    dvdId:number,
    
    panier: PanierDTO,

    id: number

    dvdSubtotal: number

    clientId: number,

    dvdQuantite: number

  }