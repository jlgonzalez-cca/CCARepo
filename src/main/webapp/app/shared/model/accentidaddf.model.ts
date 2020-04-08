import { Moment } from 'moment';

export interface IACCENTIDADDF {
  id?: number;
  iDENTIDAD?: number;
  nOMBRE?: string;
  fECHACONSTITUCION?: Moment;
  fECHAEXTINCION?: Moment;
  dOMICILIO?: string;
  cODIGOPOSTAL?: string;
  tELEFONO?: string;
  eMAIL?: string;
  dEU?: string;
  fECHAALTAAPP?: Moment;
  fECHABAJAAPP?: Moment;
  fECHAALTACENSO?: Moment;
  fECHABAJACENSO?: Moment;
  nUMEROVERSION?: number;
  fECHAVERSION?: Moment;
}

export class ACCENTIDADDF implements IACCENTIDADDF {
  constructor(
    public id?: number,
    public iDENTIDAD?: number,
    public nOMBRE?: string,
    public fECHACONSTITUCION?: Moment,
    public fECHAEXTINCION?: Moment,
    public dOMICILIO?: string,
    public cODIGOPOSTAL?: string,
    public tELEFONO?: string,
    public eMAIL?: string,
    public dEU?: string,
    public fECHAALTAAPP?: Moment,
    public fECHABAJAAPP?: Moment,
    public fECHAALTACENSO?: Moment,
    public fECHABAJACENSO?: Moment,
    public nUMEROVERSION?: number,
    public fECHAVERSION?: Moment
  ) {}
}
