import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADDVTUpdateComponent } from 'app/entities/accentidaddvt/accentidaddvt-update.component';
import { ACCENTIDADDVTService } from 'app/entities/accentidaddvt/accentidaddvt.service';
import { ACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';

describe('Component Tests', () => {
  describe('ACCENTIDADDVT Management Update Component', () => {
    let comp: ACCENTIDADDVTUpdateComponent;
    let fixture: ComponentFixture<ACCENTIDADDVTUpdateComponent>;
    let service: ACCENTIDADDVTService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADDVTUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(ACCENTIDADDVTUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ACCENTIDADDVTUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ACCENTIDADDVTService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new ACCENTIDADDVT(123);
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
        const entity = new ACCENTIDADDVT();
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
