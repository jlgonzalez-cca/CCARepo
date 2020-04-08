import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADDVTDetailComponent } from 'app/entities/accentidaddvt/accentidaddvt-detail.component';
import { ACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';

describe('Component Tests', () => {
  describe('ACCENTIDADDVT Management Detail Component', () => {
    let comp: ACCENTIDADDVTDetailComponent;
    let fixture: ComponentFixture<ACCENTIDADDVTDetailComponent>;
    const route = ({ data: of({ aCCENTIDADDVT: new ACCENTIDADDVT(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADDVTDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(ACCENTIDADDVTDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(ACCENTIDADDVTDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load aCCENTIDADDVT on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.aCCENTIDADDVT).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
