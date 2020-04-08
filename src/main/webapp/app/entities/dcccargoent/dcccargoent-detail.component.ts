import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';

@Component({
  selector: 'jhi-dcccargoent-detail',
  templateUrl: './dcccargoent-detail.component.html'
})
export class DCCCARGOENTDetailComponent implements OnInit {
  dCCCARGOENT: IDCCCARGOENT | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ dCCCARGOENT }) => (this.dCCCARGOENT = dCCCARGOENT));
  }

  previousState(): void {
    window.history.back();
  }
}
