import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption, SearchWithPagination } from 'app/shared/util/request-util';
import { IDCCCARGOENT } from 'app/shared/model/dcccargoent.model';

type EntityResponseType = HttpResponse<IDCCCARGOENT>;
type EntityArrayResponseType = HttpResponse<IDCCCARGOENT[]>;

@Injectable({ providedIn: 'root' })
export class DCCCARGOENTService {
  public resourceUrl = SERVER_API_URL + 'api/dcccargoents';
  public resourceSearchUrl = SERVER_API_URL + 'api/_search/dcccargoents';

  constructor(protected http: HttpClient) {}

  create(dCCCARGOENT: IDCCCARGOENT): Observable<EntityResponseType> {
    return this.http.post<IDCCCARGOENT>(this.resourceUrl, dCCCARGOENT, { observe: 'response' });
  }

  update(dCCCARGOENT: IDCCCARGOENT): Observable<EntityResponseType> {
    return this.http.put<IDCCCARGOENT>(this.resourceUrl, dCCCARGOENT, { observe: 'response' });
  }

  find(id: number): Observable<EntityResponseType> {
    return this.http.get<IDCCCARGOENT>(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  query(req?: any): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDCCCARGOENT[]>(this.resourceUrl, { params: options, observe: 'response' });
  }

  delete(id: number): Observable<HttpResponse<{}>> {
    return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
  }

  search(req: SearchWithPagination): Observable<EntityArrayResponseType> {
    const options = createRequestOption(req);
    return this.http.get<IDCCCARGOENT[]>(this.resourceSearchUrl, { params: options, observe: 'response' });
  }
}
