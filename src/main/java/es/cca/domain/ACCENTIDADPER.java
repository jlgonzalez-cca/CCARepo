package es.cca.domain;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Objects;

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
    private Long iDENTIDAD;

    @Column(name = "i_dcargo")
    private Long iDCARGO;

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

    public ACCENTIDADPER iDENTIDAD(Long iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
        return this;
    }

    public void setiDENTIDAD(Long iDENTIDAD) {
        this.iDENTIDAD = iDENTIDAD;
    }

    public Long getiDCARGO() {
        return iDCARGO;
    }

    public ACCENTIDADPER iDCARGO(Long iDCARGO) {
        this.iDCARGO = iDCARGO;
        return this;
    }

    public void setiDCARGO(Long iDCARGO) {
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
            ", iDENTIDAD=" + getiDENTIDAD() +
            ", iDCARGO=" + getiDCARGO() +
            ", nIF='" + getnIF() + "'" +
            ", nOMBRE='" + getnOMBRE() + "'" +
            ", aPELLIDO1='" + getaPELLIDO1() + "'" +
            ", aPELLIDO2='" + getaPELLIDO2() + "'" +
            ", eMAIL='" + geteMAIL() + "'" +
            "}";
    }
}
