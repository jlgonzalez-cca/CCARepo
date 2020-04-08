import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { DCCCARGOENTUpdateComponent } from 'app/entities/dcccargoent/dcccargoent-update.component';
import { DCCCARGOENTService } from 'app/entities/dcccargoent/dcccargoent.service';
import { DCCCARGOENT } from 'app/shared/model/dcccargoent.model';

describe('Component Tests', () => {
  describe('DCCCARGOENT Management Update Component', () => {
    let comp: DCCCARGOENTUpdateComponent;
    let fixture: ComponentFixture<DCCCARGOENTUpdateComponent>;
    let service: DCCCARGOENTService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [DCCCARGOENTUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(DCCCARGOENTUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(DCCCARGOENTUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(DCCCARGOENTService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new DCCCARGOENT(123);
        spyOn(service, 'update').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.update).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));

      it('Should call create service on save for new entity', fakeAsync(() => {
        // GIVEN
        const entity = new DCCCARGOENT();
        spyOn(service, 'create').and.returnValue(of(new HttpResponse({ body: entity })));
        comp.updateForm(entity);
        // WHEN
        comp.save();
        tick(); // simulate async

        // THEN
        expect(service.create).toHaveBeenCalledWith(entity);
        expect(comp.isSaving).toEqual(false);
      }));
    });
  });
});
