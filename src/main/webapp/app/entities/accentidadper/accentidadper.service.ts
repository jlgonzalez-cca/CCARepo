import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IACCENTIDADPER } from 'app/shared/model/accentidadper.model';

type EntityResponseType = HttpResponse<IACCENTIDADPER>;
type EntityArrayResponseType = HttpResponse<IACCENTIDADPER[]>;

@Injectable({ providedIn: 'root' })
export class ACCENTIDADPERService {
  public resourceUrl = SERVER_API_URL + 'api/accentidadpers';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/accentidadpers';

  constructor(protected http: HttpClient) {}

  create(aCCENTIDADPER: IACCENTIDADPER): Observable<EntityResponseType> {
    return this.http.post<IACCENTIDADPER>(this.resourceUrl, aCCENTIDADPER, { observe: 'response' });
  }

  update(aCCENTIDADPER: IACCENTIDADPER): Observable<EntityResponseType> {
    return this.http.put<IACCENTIDADPER>(this.resourceUrl, aCCENTIDADPER, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IACCENTIDADPER>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IACCENTIDADPER[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IACCENTIDADPER[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
