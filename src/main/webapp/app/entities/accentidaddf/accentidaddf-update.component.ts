import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IACCENTIDADDF, ACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { ACCENTIDADDFService } from './accentidaddf.service';
import { IACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';
import { ACCENTIDADDVTService } from 'app/entities/accentidaddvt/accentidaddvt.service';
import { IACCENTIDADPER } from 'app/shared/model/accentidadper.model';
import { ACCENTIDADPERService } from 'app/entities/accentidadper/accentidadper.service';

type SelectableEntity = IACCENTIDADDVT | IACCENTIDADPER;

@Component({
  selector: 'jhi-accentidaddf-update',
  templateUrl: './accentidaddf-update.component.html'
})
export class ACCENTIDADDFUpdateComponent implements OnInit {
  isSaving = false;
  accentidaddvts: IACCENTIDADDVT[] = [];
  accentidadpers: IACCENTIDADPER[] = [];
  fECHACONSTITUCIONDp: any;
  fECHAEXTINCIONDp: any;
  fECHAALTAAPPDp: any;
  fECHABAJAAPPDp: any;
  fECHAALTACENSODp: any;
  fECHABAJACENSODp: any;
  fECHAVERSIONDp: any;

  editForm = this.fb.group({
    id: [],
    iDENTIDAD: [],
    nOMBRE: [],
    fECHACONSTITUCION: [],
    fECHAEXTINCION: [],
    dOMICILIO: [],
    cODIGOPOSTAL: [],
    tELEFONO: [],
    eMAIL: [],
    dEU: [],
    fECHAALTAAPP: [],
    fECHABAJAAPP: [],
    fECHAALTACENSO: [],
    fECHABAJACENSO: [],
    nUMEROVERSION: [],
    fECHAVERSION: [],
    iDENTIDAD: [],
    iDENTIDAD: []
  });

  constructor(
    protected aCCENTIDADDFService: ACCENTIDADDFService,
    protected aCCENTIDADDVTService: ACCENTIDADDVTService,
    protected aCCENTIDADPERService: ACCENTIDADPERService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADDF }) => {
      this.updateForm(aCCENTIDADDF);

      this.aCCENTIDADDVTService.query().subscribe((res: HttpResponse<IACCENTIDADDVT[]>) => (this.accentidaddvts = res.body || []));

      this.aCCENTIDADPERService.query().subscribe((res: HttpResponse<IACCENTIDADPER[]>) => (this.accentidadpers = res.body || []));
    });
  }

  updateForm(aCCENTIDADDF: IACCENTIDADDF): void {
    this.editForm.patchValue({
      id: aCCENTIDADDF.id,
      iDENTIDAD: aCCENTIDADDF.iDENTIDAD,
      nOMBRE: aCCENTIDADDF.nOMBRE,
      fECHACONSTITUCION: aCCENTIDADDF.fECHACONSTITUCION,
      fECHAEXTINCION: aCCENTIDADDF.fECHAEXTINCION,
      dOMICILIO: aCCENTIDADDF.dOMICILIO,
      cODIGOPOSTAL: aCCENTIDADDF.cODIGOPOSTAL,
      tELEFONO: aCCENTIDADDF.tELEFONO,
      eMAIL: aCCENTIDADDF.eMAIL,
      dEU: aCCENTIDADDF.dEU,
      fECHAALTAAPP: aCCENTIDADDF.fECHAALTAAPP,
      fECHABAJAAPP: aCCENTIDADDF.fECHABAJAAPP,
      fECHAALTACENSO: aCCENTIDADDF.fECHAALTACENSO,
      fECHABAJACENSO: aCCENTIDADDF.fECHABAJACENSO,
      nUMEROVERSION: aCCENTIDADDF.nUMEROVERSION,
      fECHAVERSION: aCCENTIDADDF.fECHAVERSION,
      iDENTIDAD: aCCENTIDADDF.iDENTIDAD,
      iDENTIDAD: aCCENTIDADDF.iDENTIDAD
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const aCCENTIDADDF = this.createFromForm();
    if (aCCENTIDADDF.id !== undefined) {
      this.subscribeToSaveResponse(this.aCCENTIDADDFService.update(aCCENTIDADDF));
    } else {
      this.subscribeToSaveResponse(this.aCCENTIDADDFService.create(aCCENTIDADDF));
    }
  }

  private createFromForm(): IACCENTIDADDF {
    return {
      ...new ACCENTIDADDF(),
      id: this.editForm.get(['id'])!.value,
      iDENTIDAD: this.editForm.get(['iDENTIDAD'])!.value,
      nOMBRE: this.editForm.get(['nOMBRE'])!.value,
      fECHACONSTITUCION: this.editForm.get(['fECHACONSTITUCION'])!.value,
      fECHAEXTINCION: this.editForm.get(['fECHAEXTINCION'])!.value,
      dOMICILIO: this.editForm.get(['dOMICILIO'])!.value,
      cODIGOPOSTAL: this.editForm.get(['cODIGOPOSTAL'])!.value,
      tELEFONO: this.editForm.get(['tELEFONO'])!.value,
      eMAIL: this.editForm.get(['eMAIL'])!.value,
      dEU: this.editForm.get(['dEU'])!.value,
      fECHAALTAAPP: this.editForm.get(['fECHAALTAAPP'])!.value,
      fECHABAJAAPP: this.editForm.get(['fECHABAJAAPP'])!.value,
      fECHAALTACENSO: this.editForm.get(['fECHAALTACENSO'])!.value,
      fECHABAJACENSO: this.editForm.get(['fECHABAJACENSO'])!.value,
      nUMEROVERSION: this.editForm.get(['nUMEROVERSION'])!.value,
      fECHAVERSION: this.editForm.get(['fECHAVERSION'])!.value,
      iDENTIDAD: this.editForm.get(['iDENTIDAD'])!.value,
      iDENTIDAD: this.editForm.get(['iDENTIDAD'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IACCENTIDADDF>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }
}
