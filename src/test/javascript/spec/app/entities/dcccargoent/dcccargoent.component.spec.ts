import { ComponentFixture, TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Data } from '@angular/router';

import { TCuTestModule } from '../../../test.module';
import { DCCCARGOENTComponent } from 'app/entities/dcccargoent/dcccargoent.component';
import { DCCCARGOENTService } from 'app/entities/dcccargoent/dcccargoent.service';
import { DCCCARGOENT } from 'app/shared/model/dcccargoent.model';

describe('Component Tests', () => {
  describe('DCCCARGOENT Management Component', () => {
    let comp: DCCCARGOENTComponent;
    let fixture: ComponentFixture<DCCCARGOENTComponent>;
    let service: DCCCARGOENTService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [DCCCARGOENTComponent],
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
        .overrideTemplate(DCCCARGOENTComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DCCCARGOENTComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DCCCARGOENTService);
    });

    it('Should call load all on init', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DCCCARGOENT(123)],
            headers
          })
        )
      );

      // WHEN
      comp.ngOnInit();

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dCCCARGOENTS && comp.dCCCARGOENTS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should load a page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DCCCARGOENT(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);

      // THEN
      expect(service.query).toHaveBeenCalled();
      expect(comp.dCCCARGOENTS && comp.dCCCARGOENTS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should re-initialize the page', () => {
      // GIVEN
      const headers = new HttpHeaders().append('link', 'link;link');
      spyOn(service, 'query').and.returnValue(
        of(
          new HttpResponse({
            body: [new DCCCARGOENT(123)],
            headers
          })
        )
      );

      // WHEN
      comp.loadPage(1);
      comp.reset();

      // THEN
      expect(comp.page).toEqual(0);
      expect(service.query).toHaveBeenCalledTimes(2);
      expect(comp.dCCCARGOENTS && comp.dCCCARGOENTS[0]).toEqual(jasmine.objectContaining({ id: 123 }));
    });

    it('should calculate the sort attribute for an id', () => {
      // WHEN
      comp.ngOnInit();
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['id,asc']);
    });

    it('should calculate the sort attribute for a non-id attribute', () => {
      // INIT
      comp.ngOnInit();

      // GIVEN
      comp.predicate = 'name';

      // WHEN
      const result = comp.sort();

      // THEN
      expect(result).toEqual(['name,asc', 'id']);
    });
  });
});
