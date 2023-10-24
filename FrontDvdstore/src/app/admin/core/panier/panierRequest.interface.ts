import { PanierDvdDTO } from "./panierDvdDTO.interface"

export interface PanierRequest{
    id:number,
    
    amount: number,

    clientId: number,

    createdAt: Date,

    dvds: Array<PanierDvdDTO>  
  }