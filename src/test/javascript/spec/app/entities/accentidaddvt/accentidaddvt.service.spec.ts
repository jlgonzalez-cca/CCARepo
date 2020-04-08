import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { ACCENTIDADDVTService } from 'app/entities/accentidaddvt/accentidaddvt.service';
import { IACCENTIDADDVT, ACCENTIDADDVT } from 'app/shared/model/accentidaddvt.model';

describe('Service Tests', () => {
  describe('ACCENTIDADDVT Service', () => {
    let injector: TestBed;
    let service: ACCENTIDADDVTService;
    let httpMock: HttpTestingController;
    let elemDefault: IACCENTIDADDVT;
    let expectedResult: IACCENTIDADDVT | IACCENTIDADDVT[] | boolean | null;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ACCENTIDADDVTService);
      httpMock = injector.get(HttpTestingController);

      elemDefault = new ACCENTIDADDVT(
        0,
        0,
        0,
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        0,
        0,
        0,
        0,
        'AAAAAAA',
        0,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA'
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign({}, elemDefault);

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a ACCENTIDADDVT', () => {
        const returnedFromService = Object.assign(
          {
            id: 0
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.create(new ACCENTIDADDVT()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a ACCENTIDADDVT', () => {
        const returnedFromService = Object.assign(
          {
            iDENTIDAD: 1,
            nUMEROVERSION: 1,
            fECHAVERSION: 1,
            nIF: 'BBBBBB',
            eJERCICIO: 1,
            iDTIPO: 'BBBBBB',
            iDTIPOREND: 'BBBBBB',
            iDUNIP: 1,
            iDMUNICIPIO: 1,
            iDPROVINCIA: 1,
            iDISLA: 1,
            lOCAL: 'BBBBBB',
            iDESTADOACTIVIDAD: 1,
            cNAE: 'BBBBBB',
            cODIGOMAP: 'BBBBBB',
            cODIGOMEH: 'BBBBBB'
          },
          elemDefault
        );

        const expected = Object.assign({}, returnedFromService);

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of ACCENTIDADDVT', () => {
        const returnedFromService = Object.assign(
          {
            iDENTIDAD: 1,
            nUMEROVERSION: 1,
            fECHAVERSION: 1,
            nIF: 'BBBBBB',
            eJERCICIO: 1,
            iDTIPO: 'BBBBBB',
            iDTIPOREND: 'BBBBBB',
            iDUNIP: 1,
            iDMUNICIPIO: 1,
            iDPROVINCIA: 1,
            iDISLA: 1,
            lOCAL: 'BBBBBB',
            iDESTADOACTIVIDAD: 1,
            cNAE: 'BBBBBB',
            cODIGOMAP: 'BBBBBB',
            cODIGOMEH: 'BBBBBB'
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

      it('should delete a ACCENTIDADDVT', () => {
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
