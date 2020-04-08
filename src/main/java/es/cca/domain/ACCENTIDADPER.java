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
 * A ACCENTIDADPER.
 */
@Entity
@Table(name = "accentidadper")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "accentidadper")
public class ACCENTIDADPER implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "i_dentidad")
    private String iDENTIDAD;

    @Column(name = "i_dcargo")
    private String iDCARGO;

    @Column(name = "n_if")
    private String nIF;

    @Column(name = "n_ombre")
    private String nOMBRE;

    @Column(name = "a_pellido_1")
    private String aPELLIDO1;

    @Column(name = "a_pellido_2")
    private String aPELLIDO2;

    @Column(name = "e_mail")
    private String eMAIL;

    @OneToMany(mappedBy = "iDENTIDAD")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ACCENTIDADDF> aCCENTIDADDFS = new HashSet<>();

    @OneToMany(mappedBy = "iDCARGO")
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<DCCCARGOENT> dCCCARGOENTS = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getiDENTIDAD() {
        return iDENTIDAD;
    }

    public ACCENTIDADPER iDENTIDAD(String iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
        return this;
    }

    public void setiDENTIDAD(String iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
    }

    public String getiDCARGO() {
        return iDCARGO;
    }

    public ACCENTIDADPER iDCARGO(String iDCARGO) {
        this.iDCARGO = iDCARGO;
        return this;
    }

    public void setiDCARGO(String iDCARGO) {
        this.iDCARGO = iDCARGO;
    }

    public String getnIF() {
        return nIF;
    }

    public ACCENTIDADPER nIF(String nIF) {
        this.nIF = nIF;
        return this;
    }

    public void setnIF(String nIF) {
        this.nIF = nIF;
    }

    public String getnOMBRE() {
        return nOMBRE;
    }

    public ACCENTIDADPER nOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
        return this;
    }

    public void setnOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }

    public String getaPELLIDO1() {
        return aPELLIDO1;
    }

    public ACCENTIDADPER aPELLIDO1(String aPELLIDO1) {
        this.aPELLIDO1 = aPELLIDO1;
        return this;
    }

    public void setaPELLIDO1(String aPELLIDO1) {
        this.aPELLIDO1 = aPELLIDO1;
    }

    public String getaPELLIDO2() {
        return aPELLIDO2;
    }

    public ACCENTIDADPER aPELLIDO2(String aPELLIDO2) {
        this.aPELLIDO2 = aPELLIDO2;
        return this;
    }

    public void setaPELLIDO2(String aPELLIDO2) {
        this.aPELLIDO2 = aPELLIDO2;
    }

    public String geteMAIL() {
        return eMAIL;
    }

    public ACCENTIDADPER eMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
        return this;
    }

    public void seteMAIL(String eMAIL) {
        this.eMAIL = eMAIL;
    }

    public Set<ACCENTIDADDF> getACCENTIDADDFS() {
        return aCCENTIDADDFS;
    }

    public ACCENTIDADPER aCCENTIDADDFS(Set<ACCENTIDADDF> aCCENTIDADDFS) {
        this.aCCENTIDADDFS = aCCENTIDADDFS;
        return this;
    }

    public ACCENTIDADPER addACCENTIDADDF(ACCENTIDADDF aCCENTIDADDF) {
        this.aCCENTIDADDFS.add(aCCENTIDADDF);
        aCCENTIDADDF.setIDENTIDAD(this);
        return this;
    }

    public ACCENTIDADPER removeACCENTIDADDF(ACCENTIDADDF aCCENTIDADDF) {
        this.aCCENTIDADDFS.remove(aCCENTIDADDF);
        aCCENTIDADDF.setIDENTIDAD(null);
        return this;
    }

    public void setACCENTIDADDFS(Set<ACCENTIDADDF> aCCENTIDADDFS) {
        this.aCCENTIDADDFS = aCCENTIDADDFS;
    }

    public Set<DCCCARGOENT> getDCCCARGOENTS() {
        return dCCCARGOENTS;
    }

    public ACCENTIDADPER dCCCARGOENTS(Set<DCCCARGOENT> dCCCARGOENTS) {
        this.dCCCARGOENTS = dCCCARGOENTS;
        return this;
    }

    public ACCENTIDADPER addDCCCARGOENT(DCCCARGOENT dCCCARGOENT) {
        this.dCCCARGOENTS.add(dCCCARGOENT);
        dCCCARGOENT.setIDCARGO(this);
        return this;
    }

    public ACCENTIDADPER removeDCCCARGOENT(DCCCARGOENT dCCCARGOENT) {
        this.dCCCARGOENTS.remove(dCCCARGOENT);
        dCCCARGOENT.setIDCARGO(null);
        return this;
    }

    public void setDCCCARGOENTS(Set<DCCCARGOENT> dCCCARGOENTS) {
        this.dCCCARGOENTS = dCCCARGOENTS;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ACCENTIDADPER)) {
            return false;
        }
        return id != null && id.equals(((ACCENTIDADPER) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ACCENTIDADPER{" +
            "id=" + getId() +
            ", iDENTIDAD='" + getiDENTIDAD() + "'" +
            ", iDCARGO='" + getiDCARGO() + "'" +
            ", nIF='" + getnIF() + "'" +
            ", nOMBRE='" + getnOMBRE() + "'" +
            ", aPELLIDO1='" + getaPELLIDO1() + "'" +
            ", aPELLIDO2='" + getaPELLIDO2() + "'" +
            ", eMAIL='" + geteMAIL() + "'" +
            "}";
    }
}
