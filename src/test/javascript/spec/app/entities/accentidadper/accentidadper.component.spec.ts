import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADPERComponent } from 'app/entities/accentidadper/accentidadper.component';
import { ACCENTIDADPERService } from 'app/entities/accentidadper/accentidadper.service';
import { ACCENTIDADPER } from 'app/shared/model/accentidadper.model';

describe('Component Tests', () => {
  describe('ACCENTIDADPER Management Component', () => {
    let comp: ACCENTIDADPERComponent;
    let fixture: ComponentFixture<ACCENTIDADPERComponent>;
    let service: ACCENTIDADPERService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADPERComponent],
        providers: [
          {
            provide: ActivatedRoute,
            useValue: {
              data: {
                subscribe: (fn: (value: Data) => void) =>
                  fn({
                    pagingParams: {
                      predicate: 'id',
                      reverse: false,
                      page: 0
                    }
                  })
              }
            }
          }
        ]
      })
        .overrideTemplate(ACCENTIDADPERComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ACCENTIDADPERComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ACCENTIDADPERService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ACCENTIDADPER(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.aCCENTIDADPERS && comp.aCCENTIDADPERS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ACCENTIDADPER(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.aCCENTIDADPERS && comp.aCCENTIDADPERS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,desc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,desc', 'id']);
    });
  });
});
