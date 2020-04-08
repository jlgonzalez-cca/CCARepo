import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IACCENTIDADDVT, ACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';
import { ACCENTIDADDVTService } from './accentidaddvt.service';
import { ACCENTIDADDVTComponent } from './accentidaddvt.component';
import { ACCENTIDADDVTDetailComponent } from './accentidaddvt-detail.component';
import { ACCENTIDADDVTUpdateComponent } from './accentidaddvt-update.component';

@Injectable({ providedIn: 'root' })
export class ACCENTIDADDVTResolve implements Resolve<IACCENTIDADDVT> {
  constructor(private service: ACCENTIDADDVTService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IACCENTIDADDVT> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((aCCENTIDADDVT: HttpResponse<ACCENTIDADDVT>) => {
          if (aCCENTIDADDVT.body) {
            return of(aCCENTIDADDVT.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ACCENTIDADDVT());
  }
}

export const aCCENTIDADDVTRoute: Routes = [
  {
    path: '',
    component: ACCENTIDADDVTComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'ACCENTIDADDVTS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ACCENTIDADDVTDetailComponent,
    resolve: {
      aCCENTIDADDVT: ACCENTIDADDVTResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADDVTS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ACCENTIDADDVTUpdateComponent,
    resolve: {
      aCCENTIDADDVT: ACCENTIDADDVTResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADDVTS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ACCENTIDADDVTUpdateComponent,
    resolve: {
      aCCENTIDADDVT: ACCENTIDADDVTResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADDVTS'
    },
    canActivate: [UserRouteAccessService]
  }
];
