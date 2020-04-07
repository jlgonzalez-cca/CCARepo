import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { TCuSharedModule } from 'app/shared/shared.module';
import { DCCCARGOENTComponent } from './dcccargoent.component';
import { DCCCARGOENTDetailComponent } from './dcccargoent-detail.component';
import { DCCCARGOENTUpdateComponent } from './dcccargoent-update.component';
import { DCCCARGOENTDeleteDialogComponent } from './dcccargoent-delete-dialog.component';
import { dCCCARGOENTRoute } from './dcccargoent.route';

@NgModule({
  imports: [TCuSharedModule, RouterModule.forChild(dCCCARGOENTRoute)],
  declarations: [DCCCARGOENTComponent, DCCCARGOENTDetailComponent, DCCCARGOENTUpdateComponent, DCCCARGOENTDeleteDialogComponent],
  entryComponents: [DCCCARGOENTDeleteDialogComponent]
})
export class TCuDCCCARGOENTModule {}
