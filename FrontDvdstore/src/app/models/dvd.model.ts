export class Dvd {
    id!: number;
    name!: string;
    genre!: string;
    quantite!: number;
    prix!: number;
    picture!: string;

    constructor(){
        this.id=0;
        this.name='';
        this.genre='';
        this.quantite=0;
        this.prix=2;
        this.picture='';
    }

}