import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADDFUpdateComponent } from 'app/entities/accentidaddf/accentidaddf-update.component';
import { ACCENTIDADDFService } from 'app/entities/accentidaddf/accentidaddf.service';
import { ACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

describe('Component Tests', () => {
  describe('ACCENTIDADDF Management Update Component', () => {
    let comp: ACCENTIDADDFUpdateComponent;
    let fixture: ComponentFixture<ACCENTIDADDFUpdateComponent>;
    let service: ACCENTIDADDFService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADDFUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(ACCENTIDADDFUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ACCENTIDADDFUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ACCENTIDADDFService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new ACCENTIDADDF(123);
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
        const entity = new ACCENTIDADDF();
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
