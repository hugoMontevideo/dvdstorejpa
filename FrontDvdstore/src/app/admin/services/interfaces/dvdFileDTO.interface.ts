export interface DvdFileDTO {
    id: number|null;
    name: string;
    genre: string;
    quantite: number;
    prix: number;
    picture: File | null;
}