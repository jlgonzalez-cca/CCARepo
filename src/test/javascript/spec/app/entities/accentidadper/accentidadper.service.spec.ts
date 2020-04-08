import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ACCENTIDADPERService } from 'app/entities/accentidadper/accentidadper.service';
import { IACCENTIDADPER, ACCENTIDADPER } from 'app/shared/model/accentidadper.model';

describe('Service Tests', () => {
  describe('ACCENTIDADPER Service', () => {
    let injector: TestBed;
    let service: ACCENTIDADPERService;
    let httpMock: HttpTestingController;
    let elemDefault: IACCENTIDADPER;
    let expectedResult: IACCENTIDADPER | IACCENTIDADPER[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ACCENTIDADPERService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new ACCENTIDADPER(0, 0, 0, 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA', 'AAAAAAA');
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a ACCENTIDADPER', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new ACCENTIDADPER()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a ACCENTIDADPER', () => {
        const returnedFromService = Object.assign(
          {
            iDENTIDAD: 1,
            iDCARGO: 1,
            nIF: 'BBBBBB',
            nOMBRE: 'BBBBBB',
            aPELLIDO1: 'BBBBBB',
            aPELLIDO2: 'BBBBBB',
            eMAIL: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of ACCENTIDADPER', () => {
        const returnedFromService = Object.assign(
          {
            iDENTIDAD: 1,
            iDCARGO: 1,
            nIF: 'BBBBBB',
            nOMBRE: 'BBBBBB',
            aPELLIDO1: 'BBBBBB',
            aPELLIDO2: 'BBBBBB',
            eMAIL: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a ACCENTIDADPER', () => {
        service.delete(123).subscribe(resp => (expectedResult = resp.ok));

        const req = httpMock.expectOne({ method: 'DELETE' });
        req.flush({ status: 200 });
        expect(expectedResult);
      });
    });

    afterEach(() => {
      httpMock.verify();
    });
  });
});
