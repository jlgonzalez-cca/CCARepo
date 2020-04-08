import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

@Component({
  selector: 'jhi-accentidaddf-detail',
  templateUrl: './accentidaddf-detail.component.html'
})
export class ACCENTIDADDFDetailComponent implements OnInit {
  aCCENTIDADDF: IACCENTIDADDF | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADDF }) => (this.aCCENTIDADDF = aCCENTIDADDF));
  }

  previousState(): void {
    window.history.back();
  }
}
