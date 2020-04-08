import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IACCENTIDADPER } from 'app/shared/model/accentidadper.model';
import { ACCENTIDADPERService } from './accentidadper.service';

@Component({
  templateUrl: './accentidadper-delete-dialog.component.html'
})
export class ACCENTIDADPERDeleteDialogComponent {
  aCCENTIDADPER?: IACCENTIDADPER;

  constructor(
    protected aCCENTIDADPERService: ACCENTIDADPERService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.aCCENTIDADPERService.delete(id).subscribe(() => {
      this.eventManager.broadcast('aCCENTIDADPERListModification');
      this.activeModal.close();
    });
  }
}
