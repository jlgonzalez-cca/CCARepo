import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IDCCCARGOENT, DCCCARGOENT } from 'app/shared/model/dcccargoent.model';
import { DCCCARGOENTService } from './dcccargoent.service';
import { DCCCARGOENTComponent } from './dcccargoent.component';
import { DCCCARGOENTDetailComponent } from './dcccargoent-detail.component';
import { DCCCARGOENTUpdateComponent } from './dcccargoent-update.component';

@Injectable({ providedIn: 'root' })
export class DCCCARGOENTResolve implements Resolve<IDCCCARGOENT> {
  constructor(private service: DCCCARGOENTService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IDCCCARGOENT> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((dCCCARGOENT: HttpResponse<DCCCARGOENT>) => {
          if (dCCCARGOENT.body) {
            return of(dCCCARGOENT.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new DCCCARGOENT());
  }
}

export const dCCCARGOENTRoute: Routes = [
  {
    path: '',
    component: DCCCARGOENTComponent,
    data: {
      authorities: [Authority.USER],
      pageTitle: 'DCCCARGOENTS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: DCCCARGOENTDetailComponent,
    resolve: {
      dCCCARGOENT: DCCCARGOENTResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'DCCCARGOENTS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: DCCCARGOENTUpdateComponent,
    resolve: {
      dCCCARGOENT: DCCCARGOENTResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'DCCCARGOENTS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: DCCCARGOENTUpdateComponent,
    resolve: {
      dCCCARGOENT: DCCCARGOENTResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'DCCCARGOENTS'
    },
    canActivate: [UserRouteAccessService]
  }
];
