import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IACCENTIDADPER, ACCENTIDADPER } from 'app/shared/model/accentidadper.model';
import { ACCENTIDADPERService } from './accentidadper.service';

@Component({
  selector: 'jhi-accentidadper-update',
  templateUrl: './accentidadper-update.component.html'
})
export class ACCENTIDADPERUpdateComponent implements OnInit {
  isSaving = false;

  editForm = this.fb.group({
    id: [],
    iDENTIDAD: [],
    iDCARGO: [],
    nIF: [],
    nOMBRE: [],
    aPELLIDO1: [],
    aPELLIDO2: [],
    eMAIL: []
  });

  constructor(protected aCCENTIDADPERService: ACCENTIDADPERService, protected activatedRoute: ActivatedRoute, private fb: FormBuilder) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADPER }) => {
      this.updateForm(aCCENTIDADPER);
    });
  }

  updateForm(aCCENTIDADPER: IACCENTIDADPER): void {
    this.editForm.patchValue({
      id: aCCENTIDADPER.id,
      iDENTIDAD: aCCENTIDADPER.iDENTIDAD,
      iDCARGO: aCCENTIDADPER.iDCARGO,
      nIF: aCCENTIDADPER.nIF,
      nOMBRE: aCCENTIDADPER.nOMBRE,
      aPELLIDO1: aCCENTIDADPER.aPELLIDO1,
      aPELLIDO2: aCCENTIDADPER.aPELLIDO2,
      eMAIL: aCCENTIDADPER.eMAIL
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const aCCENTIDADPER = this.createFromForm();
    if (aCCENTIDADPER.id !== undefined) {
      this.subscribeToSaveResponse(this.aCCENTIDADPERService.update(aCCENTIDADPER));
    } else {
      this.subscribeToSaveResponse(this.aCCENTIDADPERService.create(aCCENTIDADPER));
    }
  }

  private createFromForm(): IACCENTIDADPER {
    return {
      ...new ACCENTIDADPER(),
      id: this.editForm.get(['id'])!.value,
      iDENTIDAD: this.editForm.get(['iDENTIDAD'])!.value,
      iDCARGO: this.editForm.get(['iDCARGO'])!.value,
      nIF: this.editForm.get(['nIF'])!.value,
      nOMBRE: this.editForm.get(['nOMBRE'])!.value,
      aPELLIDO1: this.editForm.get(['aPELLIDO1'])!.value,
      aPELLIDO2: this.editForm.get(['aPELLIDO2'])!.value,
      eMAIL: this.editForm.get(['eMAIL'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IACCENTIDADPER>>): void {
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
}
