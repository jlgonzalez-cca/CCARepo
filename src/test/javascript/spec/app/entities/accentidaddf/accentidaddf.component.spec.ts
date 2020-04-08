import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADDFComponent } from 'app/entities/accentidaddf/accentidaddf.component';
import { ACCENTIDADDFService } from 'app/entities/accentidaddf/accentidaddf.service';
import { ACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

describe('Component Tests', () => {
  describe('ACCENTIDADDF Management Component', () => {
    let comp: ACCENTIDADDFComponent;
    let fixture: ComponentFixture<ACCENTIDADDFComponent>;
    let service: ACCENTIDADDFService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADDFComponent],
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
        .overrideTemplate(ACCENTIDADDFComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ACCENTIDADDFComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ACCENTIDADDFService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ACCENTIDADDF(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.aCCENTIDADDFS && comp.aCCENTIDADDFS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new ACCENTIDADDF(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.aCCENTIDADDFS && comp.aCCENTIDADDFS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
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
