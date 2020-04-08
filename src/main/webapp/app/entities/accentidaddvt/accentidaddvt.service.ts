import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';

type EntityResponseType = HttpResponse<IACCENTIDADDVT>;
type EntityArrayResponseType = HttpResponse<IACCENTIDADDVT[]>;

@Injectable({ providedIn: 'root' })
export class ACCENTIDADDVTService {
  public resourceUrl = SERVER_API_URL + 'api/accentidaddvts';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/accentidaddvts';

  constructor(protected http: HttpClient) {}

  create(aCCENTIDADDVT: IACCENTIDADDVT): Observable<EntityResponseType> {
    return this.http.post<IACCENTIDADDVT>(this.resourceUrl, aCCENTIDADDVT, { observe: 'response' });
  }

  update(aCCENTIDADDVT: IACCENTIDADDVT): Observable<EntityResponseType> {
    return this.http.put<IACCENTIDADDVT>(this.resourceUrl, aCCENTIDADDVT, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IACCENTIDADDVT>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IACCENTIDADDVT[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IACCENTIDADDVT[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
