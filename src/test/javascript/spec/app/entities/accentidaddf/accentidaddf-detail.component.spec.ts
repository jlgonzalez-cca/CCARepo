import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADDFDetailComponent } from 'app/entities/accentidaddf/accentidaddf-detail.component';
import { ACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

describe('Component Tests', () => {
  describe('ACCENTIDADDF Management Detail Component', () => {
    let comp: ACCENTIDADDFDetailComponent;
    let fixture: ComponentFixture<ACCENTIDADDFDetailComponent>;
    const route = ({ data: of({ aCCENTIDADDF: new ACCENTIDADDF(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADDFDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ACCENTIDADDFDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ACCENTIDADDFDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load aCCENTIDADDF on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.aCCENTIDADDF).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
