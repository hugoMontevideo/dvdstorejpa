import{Pipe, PipeTransform} from "@angular/core";

@Pipe({
    name: 'getPanierDate'
})

export class GetPanierDate implements PipeTransform{

    transform( value: number ): string {

        let date = new Date(value);
        let year = date.getFullYear;
        var yearString = year.toString(); 

      
        return yearString;
    }

}