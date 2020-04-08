import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { ACCENTIDADDFService } from './accentidaddf.service';

@Component({
  templateUrl: './accentidaddf-delete-dialog.component.html'
})
export class ACCENTIDADDFDeleteDialogComponent {
  aCCENTIDADDF?: IACCENTIDADDF;

  constructor(
    protected aCCENTIDADDFService: ACCENTIDADDFService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.aCCENTIDADDFService.delete(id).subscribe(() => {
      this.eventManager.broadcast('aCCENTIDADDFListModification');
      this.activeModal.close();
    });
  }
}
