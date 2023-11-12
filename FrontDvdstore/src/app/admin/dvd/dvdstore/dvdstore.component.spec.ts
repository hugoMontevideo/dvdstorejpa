import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DvdstoreComponent } from './dvdstore.component';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from '../../core/components/header/header.component';
import { SidebarComponent } from '../../core/components/sidebar/sidebar.component';
import { Dvd } from '../../utils/model/dvd.interface';
import { LoginService } from 'src/app/services/login.service';
import { HttpService } from '../../services/http.service';
import { of } from 'rxjs';


describe('DvdstoreComponent', () => {
  
  let component!: DvdstoreComponent;
  let httpService: HttpService;
  let fixture: any;


  beforeEach( () => {
     TestBed.configureTestingModule({
      declarations: [ DvdstoreComponent, HeaderComponent, SidebarComponent ],
      imports: [HttpClientModule]
    })
    .compileComponents();
  });

  beforeEach(() => {
    const user = "eric";
    const secret = "maCle";
    
    fixture = TestBed.createComponent(DvdstoreComponent);
    component = fixture.componentInstance;
    let token = component.generateTUToken(user, secret);
    httpService = TestBed.inject(HttpService);
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should validate equality "Dvd[] from Svc et Dvd[] from Component"', () => {  
    // Arrange
    let dvds:Dvd[] | any ;
    let dvds2: Dvd[]| any ;
    
    // Act
    spyOn(httpService,'getDataTest').and.returnValue(of(dvds2));
    dvds = component.getDvdsTest();
    // Assert
    fixture.whenStable().then(()=>{
      
      expect(dvds2).toEqual(dvds);
    })
  });

  it('should validate equality "Dvd[] from Svc et Dvd[] from Component"', () => {  
    // Arrange
    let dvds:Dvd[] | any ;

    let dvds2: Dvd[]| any ;
    
    // Act
    spyOn(httpService,'getDataTest').and.returnValue(of(dvds2));

    dvds = component.getDvdsTest();
    // Assert
    fixture.whenStable().then(()=>{
      
      expect(dvds2).toEqual(dvds);
    })
  });

  it('should return "Hello World!"', () => {                 
    expect(component.maFonction()).toBe('Hello World!');
  });

  



});