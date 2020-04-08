import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TCuSharedModule } from 'app/shared/shared.module';
import { ACCENTIDADDVTComponent } from './accentidaddvt.component';
import { ACCENTIDADDVTDetailComponent } from './accentidaddvt-detail.component';
import { ACCENTIDADDVTUpdateComponent } from './accentidaddvt-update.component';
import { ACCENTIDADDVTDeleteDialogComponent } from './accentidaddvt-delete-dialog.component';
import { aCCENTIDADDVTRoute } from './accentidaddvt.route';

@NgModule({
  imports: [TCuSharedModule, RouterModule.forChild(aCCENTIDADDVTRoute)],
  declarations: [ACCENTIDADDVTComponent, ACCENTIDADDVTDetailComponent, ACCENTIDADDVTUpdateComponent, ACCENTIDADDVTDeleteDialogComponent],
  entryComponents: [ACCENTIDADDVTDeleteDialogComponent]
})
export class TCuACCENTIDADDVTModule {}
