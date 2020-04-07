import { TestBed, getTestBed } from '@angular/core/testing';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import * as moment from 'moment';
import { DATE_FORMAT } from 'app/shared/constants/input.constants';
import { ACCENTIDADDFService } from 'app/entities/accentidaddf/accentidaddf.service';
import { IACCENTIDADDF, ACCENTIDADDF } from 'app/shared/model/accentidaddf.model';

describe('Service Tests', () => {
  describe('ACCENTIDADDF Service', () => {
    let injector: TestBed;
    let service: ACCENTIDADDFService;
    let httpMock: HttpTestingController;
    let elemDefault: IACCENTIDADDF;
    let expectedResult: IACCENTIDADDF | IACCENTIDADDF[] | boolean | null;
    let currentDate: moment.Moment;

    beforeEach(() => {
      TestBed.configureTestingModule({
        imports: [HttpClientTestingModule]
      });
      expectedResult = null;
      injector = getTestBed();
      service = injector.get(ACCENTIDADDFService);
      httpMock = injector.get(HttpTestingController);
      currentDate = moment();

      elemDefault = new ACCENTIDADDF(
        0,
        0,
        'AAAAAAA',
        currentDate,
        currentDate,
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        'AAAAAAA',
        currentDate,
        currentDate,
        currentDate,
        currentDate,
        0,
        currentDate
      );
    });

    describe('Service methods', () => {
      it('should find an element', () => {
        const returnedFromService = Object.assign(
          {
            fECHACONSTITUCION: currentDate.format(DATE_FORMAT),
            fECHAEXTINCION: currentDate.format(DATE_FORMAT),
            fECHAALTAAPP: currentDate.format(DATE_FORMAT),
            fECHABAJAAPP: currentDate.format(DATE_FORMAT),
            fECHAALTACENSO: currentDate.format(DATE_FORMAT),
            fECHABAJACENSO: currentDate.format(DATE_FORMAT),
            fECHAVERSION: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        service.find(123).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(elemDefault);
      });

      it('should create a ACCENTIDADDF', () => {
        const returnedFromService = Object.assign(
          {
            id: 0,
            fECHACONSTITUCION: currentDate.format(DATE_FORMAT),
            fECHAEXTINCION: currentDate.format(DATE_FORMAT),
            fECHAALTAAPP: currentDate.format(DATE_FORMAT),
            fECHABAJAAPP: currentDate.format(DATE_FORMAT),
            fECHAALTACENSO: currentDate.format(DATE_FORMAT),
            fECHABAJACENSO: currentDate.format(DATE_FORMAT),
            fECHAVERSION: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            fECHACONSTITUCION: currentDate,
            fECHAEXTINCION: currentDate,
            fECHAALTAAPP: currentDate,
            fECHABAJAAPP: currentDate,
            fECHAALTACENSO: currentDate,
            fECHABAJACENSO: currentDate,
            fECHAVERSION: currentDate
          },
          returnedFromService
        );

        service.create(new ACCENTIDADDF()).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'POST' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should update a ACCENTIDADDF', () => {
        const returnedFromService = Object.assign(
          {
            iDENTIDAD: 1,
            nOMBRE: 'BBBBBB',
            fECHACONSTITUCION: currentDate.format(DATE_FORMAT),
            fECHAEXTINCION: currentDate.format(DATE_FORMAT),
            dOMICILIO: 'BBBBBB',
            cODIGOPOSTAL: 'BBBBBB',
            tELEFONO: 'BBBBBB',
            eMAIL: 'BBBBBB',
            dEU: 'BBBBBB',
            fECHAALTAAPP: currentDate.format(DATE_FORMAT),
            fECHABAJAAPP: currentDate.format(DATE_FORMAT),
            fECHAALTACENSO: currentDate.format(DATE_FORMAT),
            fECHABAJACENSO: currentDate.format(DATE_FORMAT),
            nUMEROVERSION: 1,
            fECHAVERSION: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            fECHACONSTITUCION: currentDate,
            fECHAEXTINCION: currentDate,
            fECHAALTAAPP: currentDate,
            fECHABAJAAPP: currentDate,
            fECHAALTACENSO: currentDate,
            fECHABAJACENSO: currentDate,
            fECHAVERSION: currentDate
          },
          returnedFromService
        );

        service.update(expected).subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'PUT' });
        req.flush(returnedFromService);
        expect(expectedResult).toMatchObject(expected);
      });

      it('should return a list of ACCENTIDADDF', () => {
        const returnedFromService = Object.assign(
          {
            iDENTIDAD: 1,
            nOMBRE: 'BBBBBB',
            fECHACONSTITUCION: currentDate.format(DATE_FORMAT),
            fECHAEXTINCION: currentDate.format(DATE_FORMAT),
            dOMICILIO: 'BBBBBB',
            cODIGOPOSTAL: 'BBBBBB',
            tELEFONO: 'BBBBBB',
            eMAIL: 'BBBBBB',
            dEU: 'BBBBBB',
            fECHAALTAAPP: currentDate.format(DATE_FORMAT),
            fECHABAJAAPP: currentDate.format(DATE_FORMAT),
            fECHAALTACENSO: currentDate.format(DATE_FORMAT),
            fECHABAJACENSO: currentDate.format(DATE_FORMAT),
            nUMEROVERSION: 1,
            fECHAVERSION: currentDate.format(DATE_FORMAT)
          },
          elemDefault
        );

        const expected = Object.assign(
          {
            fECHACONSTITUCION: currentDate,
            fECHAEXTINCION: currentDate,
            fECHAALTAAPP: currentDate,
            fECHABAJAAPP: currentDate,
            fECHAALTACENSO: currentDate,
            fECHABAJACENSO: currentDate,
            fECHAVERSION: currentDate
          },
          returnedFromService
        );

        service.query().subscribe(resp => (expectedResult = resp.body));

        const req = httpMock.expectOne({ method: 'GET' });
        req.flush([returnedFromService]);
        httpMock.verify();
        expect(expectedResult).toContainEqual(expected);
      });

      it('should delete a ACCENTIDADDF', () => {
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
