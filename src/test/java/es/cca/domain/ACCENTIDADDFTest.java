package es.cca.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import es.cca.web.rest.TestUtil;

public class ACCENTIDADDFTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(ACCENTIDADDF.class);
        ACCENTIDADDF aCCENTIDADDF1 = new ACCENTIDADDF();
        aCCENTIDADDF1.setId(1L);
        ACCENTIDADDF aCCENTIDADDF2 = new ACCENTIDADDF();
        aCCENTIDADDF2.setId(aCCENTIDADDF1.getId());
        assertThat(aCCENTIDADDF1).isEqualTo(aCCENTIDADDF2);
        aCCENTIDADDF2.setId(2L);
        assertThat(aCCENTIDADDF1).isNotEqualTo(aCCENTIDADDF2);
        aCCENTIDADDF1.setId(null);
        assertThat(aCCENTIDADDF1).isNotEqualTo(aCCENTIDADDF2);
    }
}
