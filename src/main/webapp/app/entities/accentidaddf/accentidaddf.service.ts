import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

type EntityResponseType = HttpResponse<IACCENTIDADDF>;
type EntityArrayResponseType = HttpResponse<IACCENTIDADDF[]>;

@Injectable({ providedIn: 'root' })
export class ACCENTIDADDFService {
  public resourceUrl = SERVER_API_URL + 'api/accentidaddfs';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/accentidaddfs';

  constructor(protected http: HttpClient) {}

  create(aCCENTIDADDF: IACCENTIDADDF): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(aCCENTIDADDF);
    return this.http
      .post<IACCENTIDADDF>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  update(aCCENTIDADDF: IACCENTIDADDF): Observable<EntityResponseType> {
    const copy = this.convertDateFromClient(aCCENTIDADDF);
    return this.http
      .put<IACCENTIDADDF>(this.resourceUrl, copy, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http
      .get<IACCENTIDADDF>(`${this.resourceUrl}/${id}`, { observe: 'response' })
      .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IACCENTIDADDF[]>(this.resourceUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http
      .get<IACCENTIDADDF[]>(this.resourceSearchUrl, { params: options, observe: 'response' })
      .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
  }

  protected convertDateFromClient(aCCENTIDADDF: IACCENTIDADDF): IACCENTIDADDF {
    const copy: IACCENTIDADDF = Object.assign({}, aCCENTIDADDF, {
      fECHACONSTITUCION:
        aCCENTIDADDF.fECHACONSTITUCION && aCCENTIDADDF.fECHACONSTITUCION.isValid()
          ? aCCENTIDADDF.fECHACONSTITUCION.format(DATE_FORMAT)
          : undefined,
      fECHAEXTINCION:
        aCCENTIDADDF.fECHAEXTINCION && aCCENTIDADDF.fECHAEXTINCION.isValid() ? aCCENTIDADDF.fECHAEXTINCION.format(DATE_FORMAT) : undefined,
      fECHAALTAAPP:
        aCCENTIDADDF.fECHAALTAAPP && aCCENTIDADDF.fECHAALTAAPP.isValid() ? aCCENTIDADDF.fECHAALTAAPP.format(DATE_FORMAT) : undefined,
      fECHABAJAAPP:
        aCCENTIDADDF.fECHABAJAAPP && aCCENTIDADDF.fECHABAJAAPP.isValid() ? aCCENTIDADDF.fECHABAJAAPP.format(DATE_FORMAT) : undefined,
      fECHAALTACENSO:
        aCCENTIDADDF.fECHAALTACENSO && aCCENTIDADDF.fECHAALTACENSO.isValid() ? aCCENTIDADDF.fECHAALTACENSO.format(DATE_FORMAT) : undefined,
      fECHABAJACENSO:
        aCCENTIDADDF.fECHABAJACENSO && aCCENTIDADDF.fECHABAJACENSO.isValid() ? aCCENTIDADDF.fECHABAJACENSO.format(DATE_FORMAT) : undefined,
      fECHAVERSION:
        aCCENTIDADDF.fECHAVERSION && aCCENTIDADDF.fECHAVERSION.isValid() ? aCCENTIDADDF.fECHAVERSION.format(DATE_FORMAT) : undefined
    });
    return copy;
  }

  protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
    if (res.body) {
      res.body.fECHACONSTITUCION = res.body.fECHACONSTITUCION ? moment(res.body.fECHACONSTITUCION) : undefined;
      res.body.fECHAEXTINCION = res.body.fECHAEXTINCION ? moment(res.body.fECHAEXTINCION) : undefined;
      res.body.fECHAALTAAPP = res.body.fECHAALTAAPP ? moment(res.body.fECHAALTAAPP) : undefined;
      res.body.fECHABAJAAPP = res.body.fECHABAJAAPP ? moment(res.body.fECHABAJAAPP) : undefined;
      res.body.fECHAALTACENSO = res.body.fECHAALTACENSO ? moment(res.body.fECHAALTACENSO) : undefined;
      res.body.fECHABAJACENSO = res.body.fECHABAJACENSO ? moment(res.body.fECHABAJACENSO) : undefined;
      res.body.fECHAVERSION = res.body.fECHAVERSION ? moment(res.body.fECHAVERSION) : undefined;
    }
    return res;
  }

  protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
    if (res.body) {
      res.body.forEach((aCCENTIDADDF: IACCENTIDADDF) => {
        aCCENTIDADDF.fECHACONSTITUCION = aCCENTIDADDF.fECHACONSTITUCION ? moment(aCCENTIDADDF.fECHACONSTITUCION) : undefined;
        aCCENTIDADDF.fECHAEXTINCION = aCCENTIDADDF.fECHAEXTINCION ? moment(aCCENTIDADDF.fECHAEXTINCION) : undefined;
        aCCENTIDADDF.fECHAALTAAPP = aCCENTIDADDF.fECHAALTAAPP ? moment(aCCENTIDADDF.fECHAALTAAPP) : undefined;
        aCCENTIDADDF.fECHABAJAAPP = aCCENTIDADDF.fECHABAJAAPP ? moment(aCCENTIDADDF.fECHABAJAAPP) : undefined;
        aCCENTIDADDF.fECHAALTACENSO = aCCENTIDADDF.fECHAALTACENSO ? moment(aCCENTIDADDF.fECHAALTACENSO) : undefined;
        aCCENTIDADDF.fECHABAJACENSO = aCCENTIDADDF.fECHABAJACENSO ? moment(aCCENTIDADDF.fECHABAJACENSO) : undefined;
        aCCENTIDADDF.fECHAVERSION = aCCENTIDADDF.fECHAVERSION ? moment(aCCENTIDADDF.fECHAVERSION) : undefined;
      });
    }
    return res;
  }
}
