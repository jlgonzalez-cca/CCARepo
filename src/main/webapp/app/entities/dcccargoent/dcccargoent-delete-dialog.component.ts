import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';
import { DCCCARGOENTService } from './dcccargoent.service';

@Component({
  templateUrl: './dcccargoent-delete-dialog.component.html'
})
export class DCCCARGOENTDeleteDialogComponent {
  dCCCARGOENT?: IDCCCARGOENT;

  constructor(
    protected dCCCARGOENTService: DCCCARGOENTService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.dCCCARGOENTService.delete(id).subscribe(() => {
      this.eventManager.broadcast('dCCCARGOENTListModification');
      this.activeModal.close();
    });
  }
}
