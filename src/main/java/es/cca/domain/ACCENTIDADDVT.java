package es.cca.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Objects;
import java.util.HashSet;
import java.util.Set;

/**
 * A ACCENTIDADDVT.
 */
@Entity
@Table(name = "accentidaddvt")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "accentidaddvt")
public class ACCENTIDADDVT implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "i_dentidad")
    private Long iDENTIDAD;

    @Column(name = "n_umeroversion")
    private Long nUMEROVERSION;

    @Column(name = "f_echaversion")
    private Long fECHAVERSION;

    @Column(name = "n_if")
    private String nIF;

    @Column(name = "e_jercicio")
    private Long eJERCICIO;

    @Column(name = "i_dtipo")
    private String iDTIPO;

    @Column(name = "i_dtiporend")
    private String iDTIPOREND;

    @Column(name = "i_dunip")
    private Long iDUNIP;

    @Column(name = "i_dmunicipio")
    private Long iDMUNICIPIO;

    @Column(name = "i_dprovincia")
    private Long iDPROVINCIA;

    @Column(name = "i_disla")
    private Long iDISLA;

    @Column(name = "l_ocal")
    private String lOCAL;

    @Column(name = "i_destadoactividad")
    private Long iDESTADOACTIVIDAD;

    @Column(name = "c_nae")
    private String cNAE;

    @Column(name = "c_odigomap")
    private String cODIGOMAP;

    @Column(name = "c_odigomeh")
    private String cODIGOMEH;

    @OneToMany(mappedBy = "iDENTIDAD")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ACCENTIDADDF> aCCENTIDADDFS = new HashSet<>();

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

    public ACCENTIDADDVT iDENTIDAD(Long iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
        return this;
    }

    public void setiDENTIDAD(Long iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
    }

    public Long getnUMEROVERSION() {
        return nUMEROVERSION;
    }

    public ACCENTIDADDVT nUMEROVERSION(Long nUMEROVERSION) {
        this.nUMEROVERSION = nUMEROVERSION;
        return this;
    }

    public void setnUMEROVERSION(Long nUMEROVERSION) {
        this.nUMEROVERSION = nUMEROVERSION;
    }

    public Long getfECHAVERSION() {
        return fECHAVERSION;
    }

    public ACCENTIDADDVT fECHAVERSION(Long fECHAVERSION) {
        this.fECHAVERSION = fECHAVERSION;
        return this;
    }

    public void setfECHAVERSION(Long fECHAVERSION) {
        this.fECHAVERSION = fECHAVERSION;
    }

    public String getnIF() {
        return nIF;
    }

    public ACCENTIDADDVT nIF(String nIF) {
        this.nIF = nIF;
        return this;
    }

    public void setnIF(String nIF) {
        this.nIF = nIF;
    }

    public Long geteJERCICIO() {
        return eJERCICIO;
    }

    public ACCENTIDADDVT eJERCICIO(Long eJERCICIO) {
        this.eJERCICIO = eJERCICIO;
        return this;
    }

    public void seteJERCICIO(Long eJERCICIO) {
        this.eJERCICIO = eJERCICIO;
    }

    public String getiDTIPO() {
        return iDTIPO;
    }

    public ACCENTIDADDVT iDTIPO(String iDTIPO) {
        this.iDTIPO = iDTIPO;
        return this;
    }

    public void setiDTIPO(String iDTIPO) {
        this.iDTIPO = iDTIPO;
    }

    public String getiDTIPOREND() {
        return iDTIPOREND;
    }

    public ACCENTIDADDVT iDTIPOREND(String iDTIPOREND) {
        this.iDTIPOREND = iDTIPOREND;
        return this;
    }

    public void setiDTIPOREND(String iDTIPOREND) {
        this.iDTIPOREND = iDTIPOREND;
    }

    public Long getiDUNIP() {
        return iDUNIP;
    }

    public ACCENTIDADDVT iDUNIP(Long iDUNIP) {
        this.iDUNIP = iDUNIP;
        return this;
    }

    public void setiDUNIP(Long iDUNIP) {
        this.iDUNIP = iDUNIP;
    }

    public Long getiDMUNICIPIO() {
        return iDMUNICIPIO;
    }

    public ACCENTIDADDVT iDMUNICIPIO(Long iDMUNICIPIO) {
        this.iDMUNICIPIO = iDMUNICIPIO;
        return this;
    }

    public void setiDMUNICIPIO(Long iDMUNICIPIO) {
        this.iDMUNICIPIO = iDMUNICIPIO;
    }

    public Long getiDPROVINCIA() {
        return iDPROVINCIA;
    }

    public ACCENTIDADDVT iDPROVINCIA(Long iDPROVINCIA) {
        this.iDPROVINCIA = iDPROVINCIA;
        return this;
    }

    public void setiDPROVINCIA(Long iDPROVINCIA) {
        this.iDPROVINCIA = iDPROVINCIA;
    }

    public Long getiDISLA() {
        return iDISLA;
    }

    public ACCENTIDADDVT iDISLA(Long iDISLA) {
        this.iDISLA = iDISLA;
        return this;
    }

    public void setiDISLA(Long iDISLA) {
        this.iDISLA = iDISLA;
    }

    public String getlOCAL() {
        return lOCAL;
    }

    public ACCENTIDADDVT lOCAL(String lOCAL) {
        this.lOCAL = lOCAL;
        return this;
    }

    public void setlOCAL(String lOCAL) {
        this.lOCAL = lOCAL;
    }

    public Long getiDESTADOACTIVIDAD() {
        return iDESTADOACTIVIDAD;
    }

    public ACCENTIDADDVT iDESTADOACTIVIDAD(Long iDESTADOACTIVIDAD) {
        this.iDESTADOACTIVIDAD = iDESTADOACTIVIDAD;
        return this;
    }

    public void setiDESTADOACTIVIDAD(Long iDESTADOACTIVIDAD) {
        this.iDESTADOACTIVIDAD = iDESTADOACTIVIDAD;
    }

    public String getcNAE() {
        return cNAE;
    }

    public ACCENTIDADDVT cNAE(String cNAE) {
        this.cNAE = cNAE;
        return this;
    }

    public void setcNAE(String cNAE) {
        this.cNAE = cNAE;
    }

    public String getcODIGOMAP() {
        return cODIGOMAP;
    }

    public ACCENTIDADDVT cODIGOMAP(String cODIGOMAP) {
        this.cODIGOMAP = cODIGOMAP;
        return this;
    }

    public void setcODIGOMAP(String cODIGOMAP) {
        this.cODIGOMAP = cODIGOMAP;
    }

    public String getcODIGOMEH() {
        return cODIGOMEH;
    }

    public ACCENTIDADDVT cODIGOMEH(String cODIGOMEH) {
        this.cODIGOMEH = cODIGOMEH;
        return this;
    }

    public void setcODIGOMEH(String cODIGOMEH) {
        this.cODIGOMEH = cODIGOMEH;
    }

    public Set<ACCENTIDADDF> getACCENTIDADDFS() {
        return aCCENTIDADDFS;
    }

    public ACCENTIDADDVT aCCENTIDADDFS(Set<ACCENTIDADDF> aCCENTIDADDFS) {
        this.aCCENTIDADDFS = aCCENTIDADDFS;
        return this;
    }

    public ACCENTIDADDVT addACCENTIDADDF(ACCENTIDADDF aCCENTIDADDF) {
        this.aCCENTIDADDFS.add(aCCENTIDADDF);
        aCCENTIDADDF.setIDENTIDAD(this);
        return this;
    }

    public ACCENTIDADDVT removeACCENTIDADDF(ACCENTIDADDF aCCENTIDADDF) {
        this.aCCENTIDADDFS.remove(aCCENTIDADDF);
        aCCENTIDADDF.setIDENTIDAD(null);
        return this;
    }

    public void setACCENTIDADDFS(Set<ACCENTIDADDF> aCCENTIDADDFS) {
        this.aCCENTIDADDFS = aCCENTIDADDFS;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ACCENTIDADDVT)) {
            return false;
        }
        return id != null && id.equals(((ACCENTIDADDVT) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ACCENTIDADDVT{" +
            "id=" + getId() +
            ", iDENTIDAD=" + getiDENTIDAD() +
            ", nUMEROVERSION=" + getnUMEROVERSION() +
            ", fECHAVERSION=" + getfECHAVERSION() +
            ", nIF='" + getnIF() + "'" +
            ", eJERCICIO=" + geteJERCICIO() +
            ", iDTIPO='" + getiDTIPO() + "'" +
            ", iDTIPOREND='" + getiDTIPOREND() + "'" +
            ", iDUNIP=" + getiDUNIP() +
            ", iDMUNICIPIO=" + getiDMUNICIPIO() +
            ", iDPROVINCIA=" + getiDPROVINCIA() +
            ", iDISLA=" + getiDISLA() +
            ", lOCAL='" + getlOCAL() + "'" +
            ", iDESTADOACTIVIDAD=" + getiDESTADOACTIVIDAD() +
            ", cNAE='" + getcNAE() + "'" +
            ", cODIGOMAP='" + getcODIGOMAP() + "'" +
            ", cODIGOMEH='" + getcODIGOMEH() + "'" +
            "}";
    }
}
