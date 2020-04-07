import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';

@Component({
  selector: 'jhi-accentidaddvt-detail',
  templateUrl: './accentidaddvt-detail.component.html'
})
export class ACCENTIDADDVTDetailComponent implements OnInit {
  aCCENTIDADDVT: IACCENTIDADDVT | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADDVT }) => (this.aCCENTIDADDVT = aCCENTIDADDVT));
  }

  previousState(): void {
    window.history.back();
  }
}
