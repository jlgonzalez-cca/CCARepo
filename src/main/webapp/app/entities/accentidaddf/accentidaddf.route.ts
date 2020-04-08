import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { JhiResolvePagingParams } from 'ng-jhipster';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { Authority } from 'app/shared/constants/authority.constants';
import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IACCENTIDADDF, ACCENTIDADDF } from 'app/shared/model/accentidaddf.model';
import { ACCENTIDADDFService } from './accentidaddf.service';
import { ACCENTIDADDFComponent } from './accentidaddf.component';
import { ACCENTIDADDFDetailComponent } from './accentidaddf-detail.component';
import { ACCENTIDADDFUpdateComponent } from './accentidaddf-update.component';

@Injectable({ providedIn: 'root' })
export class ACCENTIDADDFResolve implements Resolve<IACCENTIDADDF> {
  constructor(private service: ACCENTIDADDFService, private router: Router) {}

  resolve(route: ActivatedRouteSnapshot): Observable<IACCENTIDADDF> | Observable<never> {
    const id = route.params['id'];
    if (id) {
      return this.service.find(id).pipe(
        flatMap((aCCENTIDADDF: HttpResponse<ACCENTIDADDF>) => {
          if (aCCENTIDADDF.body) {
            return of(aCCENTIDADDF.body);
          } else {
            this.router.navigate(['404']);
            return EMPTY;
          }
        })
      );
    }
    return of(new ACCENTIDADDF());
  }
}

export const aCCENTIDADDFRoute: Routes = [
  {
    path: '',
    component: ACCENTIDADDFComponent,
    resolve: {
      pagingParams: JhiResolvePagingParams
    },
    data: {
      authorities: [Authority.USER],
      defaultSort: 'id,asc',
      pageTitle: 'ACCENTIDADDFS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/view',
    component: ACCENTIDADDFDetailComponent,
    resolve: {
      aCCENTIDADDF: ACCENTIDADDFResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADDFS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: 'new',
    component: ACCENTIDADDFUpdateComponent,
    resolve: {
      aCCENTIDADDF: ACCENTIDADDFResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADDFS'
    },
    canActivate: [UserRouteAccessService]
  },
  {
    path: ':id/edit',
    component: ACCENTIDADDFUpdateComponent,
    resolve: {
      aCCENTIDADDF: ACCENTIDADDFResolve
    },
    data: {
      authorities: [Authority.USER],
      pageTitle: 'ACCENTIDADDFS'
    },
    canActivate: [UserRouteAccessService]
  }
];
