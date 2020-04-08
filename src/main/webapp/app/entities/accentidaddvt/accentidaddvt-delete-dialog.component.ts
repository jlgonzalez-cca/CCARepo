import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { JhiEventManager } from 'ng-jhipster';

import { IACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';
import { ACCENTIDADDVTService } from './accentidaddvt.service';

@Component({
  templateUrl: './accentidaddvt-delete-dialog.component.html'
})
export class ACCENTIDADDVTDeleteDialogComponent {
  aCCENTIDADDVT?: IACCENTIDADDVT;

  constructor(
    protected aCCENTIDADDVTService: ACCENTIDADDVTService,
    public activeModal: NgbActiveModal,
    protected eventManager: JhiEventManager
  ) {}

  cancel(): void {
    this.activeModal.dismiss();
  }

  confirmDelete(id: number): void {
    this.aCCENTIDADDVTService.delete(id).subscribe(() => {
      this.eventManager.broadcast('aCCENTIDADDVTListModification');
      this.activeModal.close();
    });
  }
}
