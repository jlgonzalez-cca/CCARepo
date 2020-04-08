import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IACCENTIDADPER, ACCENTIDADPER } from 'app/shared/model/accentidadper.model';
import { ACCENTIDADPERService } from './accentidadper.service';
import { ACCENTIDADPERComponent } from './accentidadper.component';
import { ACCENTIDADPERDetailComponent } from './accentidadper-detail.component';
import { ACCENTIDADPERUpdateComponent } from './accentidadper-update.component';

@Injectable({ providedIn: 'root' })
export class ACCENTIDADPERResolve implements Resolve<IACCENTIDADPER> {
  constructor(private service: ACCENTIDADPERService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IACCENTIDADPER> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((aCCENTIDADPER: HttpResponse<ACCENTIDADPER>) => {
          if (aCCENTIDADPER.body) {
            return of(aCCENTIDADPER.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ACCENTIDADPER());
  }
}

export const aCCENTIDADPERRoute: Routes = [
  {
    path: '',
    component: ACCENTIDADPERComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'ACCENTIDADPERS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ACCENTIDADPERDetailComponent,
    resolve: {
      aCCENTIDADPER: ACCENTIDADPERResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADPERS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ACCENTIDADPERUpdateComponent,
    resolve: {
      aCCENTIDADPER: ACCENTIDADPERResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADPERS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ACCENTIDADPERUpdateComponent,
    resolve: {
      aCCENTIDADPER: ACCENTIDADPERResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADPERS'
    },
    canActivate: [UserRouteAccessService]
  }
];
