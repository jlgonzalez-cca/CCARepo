package es.cca.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import es.cca.web.rest.TestUtil;

public class ACCENTIDADPERTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ACCENTIDADPER.class);
        ACCENTIDADPER aCCENTIDADPER1 = new ACCENTIDADPER();
        aCCENTIDADPER1.setId(1L);
        ACCENTIDADPER aCCENTIDADPER2 = new ACCENTIDADPER();
        aCCENTIDADPER2.setId(aCCENTIDADPER1.getId());
        assertThat(aCCENTIDADPER1).isEqualTo(aCCENTIDADPER2);
        aCCENTIDADPER2.setId(2L);
        assertThat(aCCENTIDADPER1).isNotEqualTo(aCCENTIDADPER2);
        aCCENTIDADPER1.setId(null);
        assertThat(aCCENTIDADPER1).isNotEqualTo(aCCENTIDADPER2);
    }
}
