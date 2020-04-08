export interface IACCENTIDADPER {
  id?: number;
  iDENTIDAD?: number;
  iDCARGO?: number;
  nIF?: string;
  nOMBRE?: string;
  aPELLIDO1?: string;
  aPELLIDO2?: string;
  eMAIL?: string;
}

export class ACCENTIDADPER implements IACCENTIDADPER {
  constructor(
    public id?: number,
    public iDENTIDAD?: number,
    public iDCARGO?: number,
    public nIF?: string,
    public nOMBRE?: string,
    public aPELLIDO1?: string,
    public aPELLIDO2?: string,
    public eMAIL?: string
  ) {}
}
