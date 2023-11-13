import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController} from '@angular/common/http/testing';
import { HttpClientModule } from '@angular/common/http';
import { HeaderComponent } from '../../core/components/header/header.component';
import { SidebarComponent } from '../../core/components/sidebar/sidebar.component';
import { HttpService } from '../../services/http.service';
import { DvdItemComponent } from './dvd-item.component';
import { ActivatedRoute, convertToParamMap } from '@angular/router';
import { Dvd } from '../../utils/model/dvd.interface';


describe('DvdItemComponent', () => {
  let dvdItemComponent: DvdItemComponent | undefined;
  let httpService: HttpService;
  let route: ActivatedRoute;
  let fixture: any;
  let httpTestingController: HttpTestingController;

  beforeEach( () => {
     TestBed.configureTestingModule({
      declarations: [ DvdItemComponent, HeaderComponent, SidebarComponent ],
      imports: [HttpClientModule, HttpClientTestingModule],
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
    route = TestBed.inject(ActivatedRoute);
    httpTestingController = TestBed.inject(HttpTestingController);
  });

 afterEach(() => {
    httpTestingController.verify();
 })
 

  it('should create', () => {
    expect(dvdItemComponent).toBeTruthy();
  });

  it('should be instance of "Dvd"', () => {  
   // Arrange
   const mockDvdItem: Dvd | undefined = {
        id:17,
        name:"Nouveau départ",    
        genre: "comedie",
        quantite: 54,
        prix: 17.5,
        picture: "nouveau_depart.webp"
    };

    // Act
    dvdItemComponent?.getDvdById('dvds', 17);
    
    let req = httpTestingController.expectOne('http://localhost:80/dvds/17');
    expect(req.request.method).toEqual('GET');
    req.flush(mockDvdItem);
    // Assert
    expect(dvdItemComponent?.currentDvd).toEqual(mockDvdItem);
  });


});