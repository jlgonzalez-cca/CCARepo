import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpResponse } from '@angular/common/http';
import { FormBuilder } from '@angular/forms';
import { of } from 'rxjs';

import { TCuTestModule } from '../../../test.module';
import { ACCENTIDADPERUpdateComponent } from 'app/entities/accentidadper/accentidadper-update.component';
import { ACCENTIDADPERService } from 'app/entities/accentidadper/accentidadper.service';
import { ACCENTIDADPER } from 'app/shared/model/accentidadper.model';

describe('Component Tests', () => {
  describe('ACCENTIDADPER Management Update Component', () => {
    let comp: ACCENTIDADPERUpdateComponent;
    let fixture: ComponentFixture<ACCENTIDADPERUpdateComponent>;
    let service: ACCENTIDADPERService;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [TCuTestModule],
        declarations: [ACCENTIDADPERUpdateComponent],
        providers: [FormBuilder]
      })
        .overrideTemplate(ACCENTIDADPERUpdateComponent, '')
        .compileComponents();

      fixture = TestBed.createComponent(ACCENTIDADPERUpdateComponent);
      comp = fixture.componentInstance;
      service = fixture.debugElement.injector.get(ACCENTIDADPERService);
    });

    describe('save', () => {
      it('Should call update service on save for existing entity', fakeAsync(() => {
        // GIVEN
        const entity = new ACCENTIDADPER(123);
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
        const entity = new ACCENTIDADPER();
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
