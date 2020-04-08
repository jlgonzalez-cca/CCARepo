import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'accentidaddf',
        loadChildren: () => import('./accentidaddf/accentidaddf.module').then(m => m.TCuACCENTIDADDFModule)
      },
      {
        path: 'accentidaddvt',
        loadChildren: () => import('./accentidaddvt/accentidaddvt.module').then(m => m.TCuACCENTIDADDVTModule)
      },
      {
        path: 'accentidadper',
        loadChildren: () => import('./accentidadper/accentidadper.module').then(m => m.TCuACCENTIDADPERModule)
      },
      {
        path: 'dcccargoent',
        loadChildren: () => import('./dcccargoent/dcccargoent.module').then(m => m.TCuDCCCARGOENTModule)
      }
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ])
  ]
})
export class TCuEntityModule {}
