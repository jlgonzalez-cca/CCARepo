export interface IDCCCARGOENT {
  id?: number;
  iDCARGO?: number;
  nOMBRE?: string;
}

export class DCCCARGOENT implements IDCCCARGOENT {
  constructor(public id?: number, public iDCARGO?: number, public nOMBRE?: string) {}
}
