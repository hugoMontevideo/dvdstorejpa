// import { ComponentFixture, TestBed } from '@angular/core/testing';
// import { DvdstoreComponent } from './dvdstore.component';
// import { HttpClientModule } from '@angular/common/http';
// import { HeaderComponent } from '../../core/components/header/header.component';
// import { SidebarComponent } from '../../core/components/sidebar/sidebar.component';
// import { Dvd } from '../../utils/model/dvd.interface';
// import { HttpService } from '../../services/http.service';
// import { of } from 'rxjs';


// describe('DvdstoreComponent', () => {
  
//   let dvdStoreComponent: DvdstoreComponent;
//   let httpService: HttpService;
//   let fixture: any;


//   beforeEach( () => {
//      TestBed.configureTestingModule({
//       declarations: [ DvdstoreComponent, HeaderComponent, SidebarComponent ],
//       imports: [HttpClientModule]
//     })
//     .compileComponents();
//   });

//   beforeEach(() => {
//     const user = "eric";
//     const secret = "maCle";
    
//     fixture = TestBed.createComponent(DvdstoreComponent);
//     dvdStoreComponent = fixture.componentInstance;
//     httpService = TestBed.inject(HttpService);
//   });

//   it('should create', () => {
//     expect(dvdStoreComponent).toBeTruthy();
//   });


//   it('should validate equality "Dvd[] from Svc et Dvd[] from Component"', () => {  
//     // Arrange
//     let dvds:Dvd[] | any ;

//     let dvds2:Dvd[]| any ;
    
//     // Act
//     // Les simulateurs spyOn et of sont utilisés pour controler le comportement des dependances asynchrones lors des tests uitaires
//     spyOn(httpService,'getDataTest').and.returnValue(of(dvds2));
//     console.log("dvds2", dvds2);
    
//     dvds = dvdStoreComponent.getDvds();
//     console.log("final dvds" , dvds);
    
//     // Assert
//     fixture.whenStable().then(()=>{
//       expect(dvds2).toEqual(dvds);
//     })
//   });

//   it('should return "Hello World!"', () => {                 
//     expect(dvdStoreComponent.maFonction()).toBe('Hello World!');
//   });

  



// });