package es.cca.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import org.springframework.data.elasticsearch.annotations.FieldType;
import java.io.Serializable;
import java.util.Objects;

/**
 * not an ignored comment
 */
@ApiModel(description = "not an ignored comment")
@Entity
@Table(name = "dcccargoent")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@org.springframework.data.elasticsearch.annotations.Document(indexName = "dcccargoent")
public class DCCCARGOENT implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "i_dcargo")
    private Long iDCARGO;

    @Column(name = "n_ombre")
    private String nOMBRE;

    @ManyToOne
    @JsonIgnoreProperties("dCCCARGOENTS")
    private ACCENTIDADPER iDCARGO;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getiDCARGO() {
        return iDCARGO;
    }

    public DCCCARGOENT iDCARGO(Long iDCARGO) {
        this.iDCARGO = iDCARGO;
        return this;
    }

    public void setiDCARGO(Long iDCARGO) {
        this.iDCARGO = iDCARGO;
    }

    public String getnOMBRE() {
        return nOMBRE;
    }

    public DCCCARGOENT nOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
        return this;
    }

    public void setnOMBRE(String nOMBRE) {
        this.nOMBRE = nOMBRE;
    }

    public ACCENTIDADPER getIDCARGO() {
        return iDCARGO;
    }

    public DCCCARGOENT iDCARGO(ACCENTIDADPER aCCENTIDADPER) {
        this.iDCARGO = aCCENTIDADPER;
        return this;
    }

    public void setIDCARGO(ACCENTIDADPER aCCENTIDADPER) {
        this.iDCARGO = aCCENTIDADPER;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DCCCARGOENT)) {
            return false;
        }
        return id != null && id.equals(((DCCCARGOENT) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DCCCARGOENT{" +
            "id=" + getId() +
            ", iDCARGO=" + getiDCARGO() +
            ", nOMBRE='" + getnOMBRE() + "'" +
            "}";
    }
}
