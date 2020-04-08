package es.cca.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import es.cca.web.rest.TestUtil;

public class ACCENTIDADDVTTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ACCENTIDADDVT.class);
        ACCENTIDADDVT aCCENTIDADDVT1 = new ACCENTIDADDVT();
        aCCENTIDADDVT1.setId(1L);
        ACCENTIDADDVT aCCENTIDADDVT2 = new ACCENTIDADDVT();
        aCCENTIDADDVT2.setId(aCCENTIDADDVT1.getId());
        assertThat(aCCENTIDADDVT1).isEqualTo(aCCENTIDADDVT2);
        aCCENTIDADDVT2.setId(2L);
        assertThat(aCCENTIDADDVT1).isNotEqualTo(aCCENTIDADDVT2);
        aCCENTIDADDVT1.setId(null);
        assertThat(aCCENTIDADDVT1).isNotEqualTo(aCCENTIDADDVT2);
    }
}
