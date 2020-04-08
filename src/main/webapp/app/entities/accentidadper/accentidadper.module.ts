import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TCuSharedModule } from 'app/shared/shared.module';
import { ACCENTIDADPERComponent } from './accentidadper.component';
import { ACCENTIDADPERDetailComponent } from './accentidadper-detail.component';
import { ACCENTIDADPERUpdateComponent } from './accentidadper-update.component';
import { ACCENTIDADPERDeleteDialogComponent } from './accentidadper-delete-dialog.component';
import { aCCENTIDADPERRoute } from './accentidadper.route';

@NgModule({
  imports: [TCuSharedModule, RouterModule.forChild(aCCENTIDADPERRoute)],
  declarations: [ACCENTIDADPERComponent, ACCENTIDADPERDetailComponent, ACCENTIDADPERUpdateComponent, ACCENTIDADPERDeleteDialogComponent],
  entryComponents: [ACCENTIDADPERDeleteDialogComponent]
})
export class TCuACCENTIDADPERModule {}
