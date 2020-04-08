package es.cca.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link ACCENTIDADDFSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class ACCENTIDADDFSearchRepositoryMockConfiguration {

    @MockBean
    private ACCENTIDADDFSearchRepository mockACCENTIDADDFSearchRepository;

}
