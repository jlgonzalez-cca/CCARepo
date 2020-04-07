import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ActivatedRoute } from '@angular/router';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { DCCCARGOENTDetailComponent } from 'app/entities/dcccargoent/dcccargoent-detail.component';
import { DCCCARGOENT } from 'app/shared/model/dcccargoent.model';

describe('Component Tests', () => {
  describe('DCCCARGOENT Management Detail Component', () => {
    let comp: DCCCARGOENTDetailComponent;
    let fixture: ComponentFixture<DCCCARGOENTDetailComponent>;
    const route = ({ data: of({ dCCCARGOENT: new DCCCARGOENT(123) }) } as any) as ActivatedRoute;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [DCCCARGOENTDetailComponent],
        providers: [{ provide: ActivatedRoute, useValue: route }]
      })
        .overrideTemplate(DCCCARGOENTDetailComponent, '')
        .compileComponents();
      fixture = TestBed.createComponent(DCCCARGOENTDetailComponent);
      comp = fixture.componentInstance;
    });

    describe('OnInit', () => {
      it('Should load dCCCARGOENT on init', () => {
        // WHEN
        comp.ngOnInit();

        // THEN
        expect(comp.dCCCARGOENT).toEqual(jasmine.objectContaining({ id: 123 }));
      });
    });
  });
});
