import { PanierDvdDTO } from "./panierDvdDTO.interface"

export interface PanierDTO{
    id:number,
    
    amount: number,

    clientId: number,

    createdAt: Date,

    dvds: Array<PanierDvdDTO>  
  }