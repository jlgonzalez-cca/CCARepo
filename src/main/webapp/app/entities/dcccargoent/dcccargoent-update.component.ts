import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';

import { IDCCCARGOENT, DCCCARGOENT } from 'app/shared/model/dcccargoent.model';
import { DCCCARGOENTService } from './dcccargoent.service';
import { IACCENTIDADPER } from 'app/shared/model/accentidadper.model';
import { ACCENTIDADPERService } from 'app/entities/accentidadper/accentidadper.service';

@Component({
  selector: 'jhi-dcccargoent-update',
  templateUrl: './dcccargoent-update.component.html'
})
export class DCCCARGOENTUpdateComponent implements OnInit {
  isSaving = false;
  accentidadpers: IACCENTIDADPER[] = [];

  editForm = this.fb.group({
    id: [],
    iDCARGO: [],
    nOMBRE: [],
    iDCARGO: []
  });

  constructor(
    protected dCCCARGOENTService: DCCCARGOENTService,
    protected aCCENTIDADPERService: ACCENTIDADPERService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dCCCARGOENT }) => {
      this.updateForm(dCCCARGOENT);

      this.aCCENTIDADPERService.query().subscribe((res: HttpResponse<IACCENTIDADPER[]>) => (this.accentidadpers = res.body || []));
    });
  }

  updateForm(dCCCARGOENT: IDCCCARGOENT): void {
    this.editForm.patchValue({
      id: dCCCARGOENT.id,
      iDCARGO: dCCCARGOENT.iDCARGO,
      nOMBRE: dCCCARGOENT.nOMBRE,
      iDCARGO: dCCCARGOENT.iDCARGO
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const dCCCARGOENT = this.createFromForm();
    if (dCCCARGOENT.id !== undefined) {
      this.subscribeToSaveResponse(this.dCCCARGOENTService.update(dCCCARGOENT));
    } else {
      this.subscribeToSaveResponse(this.dCCCARGOENTService.create(dCCCARGOENT));
    }
  }

  private createFromForm(): IDCCCARGOENT {
    return {
      ...new DCCCARGOENT(),
      id: this.editForm.get(['id'])!.value,
      iDCARGO: this.editForm.get(['iDCARGO'])!.value,
      nOMBRE: this.editForm.get(['nOMBRE'])!.value,
      iDCARGO: this.editForm.get(['iDCARGO'])!.value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IDCCCARGOENT>>): void {
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

  trackById(index: number, item: IACCENTIDADPER): any {
    return item.id;
  }
}
