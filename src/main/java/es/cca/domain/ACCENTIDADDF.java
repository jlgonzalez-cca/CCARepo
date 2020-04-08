package es.cca.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Objects;
import java.time.LocalDate;

/**
 * A ACCENTIDADDF.
 */
@Entity
@Table(name = "accentidaddf")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "accentidaddf")
public class ACCENTIDADDF implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "i_dentidad")
    private Long iDENTIDAD;

    @Column(name = "n_ombre")
    private String nOMBRE;

    @Column(name = "f_echaconstitucion")
    private LocalDate fECHACONSTITUCION;

    @Column(name = "f_echaextincion")
    private LocalDate fECHAEXTINCION;

    @Column(name = "d_omicilio")
    private String dOMICILIO;

    @Column(name = "c_odigopostal")
    private String cODIGOPOSTAL;

    @Column(name = "t_elefono")
    private String tELEFONO;

    @Column(name = "e_mail")
    private String eMAIL;

    @Column(name = "d_eu")
    private String dEU;

    @Column(name = "f_echaaltaapp")
    private LocalDate fECHAALTAAPP;

    @Column(name = "f_echabajaapp")
    private LocalDate fECHABAJAAPP;

    @Column(name = "f_echaaltacenso")
    private LocalDate fECHAALTACENSO;

    @Column(name = "f_echabajacenso")
    private LocalDate fECHABAJACENSO;

    @Column(name = "n_umeroversion")
    private Long nUMEROVERSION;

    @Column(name = "f_echaversion")
    private LocalDate fECHAVERSION;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getiDENTIDAD() {
        return iDENTIDAD;
    }

    public ACCENTIDADDF iDENTIDAD(Long iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
        return this;
    }

    public void setiDENTIDAD(Long iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
    }

    public String getnOMBRE() {
        return nOMBRE;
    }

    public ACCENTIDADDF nOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
        return this;
    }

    public void setnOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }

    public LocalDate getfECHACONSTITUCION() {
        return fECHACONSTITUCION;
    }

    public ACCENTIDADDF fECHACONSTITUCION(LocalDate fECHACONSTITUCION) {
        this.fECHACONSTITUCION = fECHACONSTITUCION;
        return this;
    }

    public void setfECHACONSTITUCION(LocalDate fECHACONSTITUCION) {
        this.fECHACONSTITUCION = fECHACONSTITUCION;
    }

    public LocalDate getfECHAEXTINCION() {
        return fECHAEXTINCION;
    }

    public ACCENTIDADDF fECHAEXTINCION(LocalDate fECHAEXTINCION) {
        this.fECHAEXTINCION = fECHAEXTINCION;
        return this;
    }

    public void setfECHAEXTINCION(LocalDate fECHAEXTINCION) {
        this.fECHAEXTINCION = fECHAEXTINCION;
    }

    public String getdOMICILIO() {
        return dOMICILIO;
    }

    public ACCENTIDADDF dOMICILIO(String dOMICILIO) {
        this.dOMICILIO = dOMICILIO;
        return this;
    }

    public void setdOMICILIO(String dOMICILIO) {
        this.dOMICILIO = dOMICILIO;
    }

    public String getcODIGOPOSTAL() {
        return cODIGOPOSTAL;
    }

    public ACCENTIDADDF cODIGOPOSTAL(String cODIGOPOSTAL) {
        this.cODIGOPOSTAL = cODIGOPOSTAL;
        return this;
    }

    public void setcODIGOPOSTAL(String cODIGOPOSTAL) {
        this.cODIGOPOSTAL = cODIGOPOSTAL;
    }

    public String gettELEFONO() {
        return tELEFONO;
    }

    public ACCENTIDADDF tELEFONO(String tELEFONO) {
        this.tELEFONO = tELEFONO;
        return this;
    }

    public void settELEFONO(String tELEFONO) {
        this.tELEFONO = tELEFONO;
    }

    public String geteMAIL() {
        return eMAIL;
    }

    public ACCENTIDADDF eMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
        return this;
    }

    public void seteMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public String getdEU() {
        return dEU;
    }

    public ACCENTIDADDF dEU(String dEU) {
        this.dEU = dEU;
        return this;
    }

    public void setdEU(String dEU) {
        this.dEU = dEU;
    }

    public LocalDate getfECHAALTAAPP() {
        return fECHAALTAAPP;
    }

    public ACCENTIDADDF fECHAALTAAPP(LocalDate fECHAALTAAPP) {
        this.fECHAALTAAPP = fECHAALTAAPP;
        return this;
    }

    public void setfECHAALTAAPP(LocalDate fECHAALTAAPP) {
        this.fECHAALTAAPP = fECHAALTAAPP;
    }

    public LocalDate getfECHABAJAAPP() {
        return fECHABAJAAPP;
    }

    public ACCENTIDADDF fECHABAJAAPP(LocalDate fECHABAJAAPP) {
        this.fECHABAJAAPP = fECHABAJAAPP;
        return this;
    }

    public void setfECHABAJAAPP(LocalDate fECHABAJAAPP) {
        this.fECHABAJAAPP = fECHABAJAAPP;
    }

    public LocalDate getfECHAALTACENSO() {
        return fECHAALTACENSO;
    }

    public ACCENTIDADDF fECHAALTACENSO(LocalDate fECHAALTACENSO) {
        this.fECHAALTACENSO = fECHAALTACENSO;
        return this;
    }

    public void setfECHAALTACENSO(LocalDate fECHAALTACENSO) {
        this.fECHAALTACENSO = fECHAALTACENSO;
    }

    public LocalDate getfECHABAJACENSO() {
        return fECHABAJACENSO;
    }

    public ACCENTIDADDF fECHABAJACENSO(LocalDate fECHABAJACENSO) {
        this.fECHABAJACENSO = fECHABAJACENSO;
        return this;
    }

    public void setfECHABAJACENSO(LocalDate fECHABAJACENSO) {
        this.fECHABAJACENSO = fECHABAJACENSO;
    }

    public Long getnUMEROVERSION() {
        return nUMEROVERSION;
    }

    public ACCENTIDADDF nUMEROVERSION(Long nUMEROVERSION) {
        this.nUMEROVERSION = nUMEROVERSION;
        return this;
    }

    public void setnUMEROVERSION(Long nUMEROVERSION) {
        this.nUMEROVERSION = nUMEROVERSION;
    }

    public LocalDate getfECHAVERSION() {
        return fECHAVERSION;
    }

    public ACCENTIDADDF fECHAVERSION(LocalDate fECHAVERSION) {
        this.fECHAVERSION = fECHAVERSION;
        return this;
    }

    public void setfECHAVERSION(LocalDate fECHAVERSION) {
        this.fECHAVERSION = fECHAVERSION;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ACCENTIDADDF)) {
            return false;
        }
        return id != null && id.equals(((ACCENTIDADDF) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ACCENTIDADDF{" +
            "id=" + getId() +
            ", iDENTIDAD=" + getiDENTIDAD() +
            ", nOMBRE='" + getnOMBRE() + "'" +
            ", fECHACONSTITUCION='" + getfECHACONSTITUCION() + "'" +
            ", fECHAEXTINCION='" + getfECHAEXTINCION() + "'" +
            ", dOMICILIO='" + getdOMICILIO() + "'" +
            ", cODIGOPOSTAL='" + getcODIGOPOSTAL() + "'" +
            ", tELEFONO='" + gettELEFONO() + "'" +
            ", eMAIL='" + geteMAIL() + "'" +
            ", dEU='" + getdEU() + "'" +
            ", fECHAALTAAPP='" + getfECHAALTAAPP() + "'" +
            ", fECHABAJAAPP='" + getfECHABAJAAPP() + "'" +
            ", fECHAALTACENSO='" + getfECHAALTACENSO() + "'" +
            ", fECHABAJACENSO='" + getfECHABAJACENSO() + "'" +
            ", nUMEROVERSION=" + getnUMEROVERSION() +
            ", fECHAVERSION='" + getfECHAVERSION() + "'" +
            "}";
    }
}
