import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADPERDetailComponent } from 'app/entities/accentidadper/accentidadper-detail.component';
import { ACCENTIDADPER } from 'app/shared/model/accentidadper.model';

describe('Component Tests', () => {
  describe('ACCENTIDADPER Management Detail Component', () => {
    let comp: ACCENTIDADPERDetailComponent;
    let fixture: ComponentFixture<ACCENTIDADPERDetailComponent>;
    const route = ({ data: of({ aCCENTIDADPER: new ACCENTIDADPER(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADPERDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ACCENTIDADPERDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ACCENTIDADPERDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load aCCENTIDADPER on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.aCCENTIDADPER).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
