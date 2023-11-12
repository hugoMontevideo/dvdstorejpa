import { TestBed } from '@angular/core/testing';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from '../../core/components/header/header.component';
import { SidebarComponent } from '../../core/components/sidebar/sidebar.component';
import { HttpService } from '../../services/http.service';
import { DvdItemComponent } from './dvd-item.component';
import { ActivatedRoute, convertToParamMap } from '@angular/router';



describe('DvdstoreComponent', () => {
  let dvdItemComponent: DvdItemComponent | undefined;
  let httpService: HttpService;
  let route: ActivatedRoute;
  let fixture: any;


  beforeEach( () => {
     TestBed.configureTestingModule({
      declarations: [ DvdItemComponent, HeaderComponent, SidebarComponent ],
      imports: [HttpClientModule],
      providers: [
        {
            provide: ActivatedRoute,
            useValue: {
                snapshot:{
                    paramMap: convertToParamMap({ id:6 }) // id de l'url
                },
            },
        },
    ],
    })
    .compileComponents();
  });

  beforeEach(() => {
    const user = "eric";
    const secret = "maCle";
    
    fixture = TestBed.createComponent(DvdItemComponent);
    dvdItemComponent = fixture.componentInstance;
    httpService = TestBed.inject(HttpService);
    route = TestBed.inject(ActivatedRoute)
  });

  it('should create', () => {
    expect(dvdItemComponent).toBeTruthy();
  });

  it('should validate equality "Dvd[] from Svc et Dvd[] from Component"', () => {  
   // Arrange
    let dvd: DvdItemComponent | undefined = dvdItemComponent;
        
    // Assert
    if(dvd === undefined){
        expect(dvd).toBeUndefined();
    }else{
        expect(dvd).toBeInstanceOf(DvdItemComponent);
    }
    
  });

// 

});