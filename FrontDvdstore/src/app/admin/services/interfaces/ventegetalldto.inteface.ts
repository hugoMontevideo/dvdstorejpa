export interface VenteGetAllDTO{
    id: number|null;
    dateDeVente: string;
    dvdstore_id: number;
    dvdstore_name: string;
    quantite: number;
    client_id: number;
    client_name: string;
    montant: number;
}