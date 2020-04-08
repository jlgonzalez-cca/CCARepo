import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { IACCENTIDADPER } from 'app/shared/model/accentidadper.model';

@Component({
  selector: 'jhi-accentidadper-detail',
  templateUrl: './accentidadper-detail.component.html'
})
export class ACCENTIDADPERDetailComponent implements OnInit {
  aCCENTIDADPER: IACCENTIDADPER | null = null;

  constructor(protected activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ aCCENTIDADPER }) => (this.aCCENTIDADPER = aCCENTIDADPER));
  }

  previousState(): void {
    window.history.back();
  }
}
