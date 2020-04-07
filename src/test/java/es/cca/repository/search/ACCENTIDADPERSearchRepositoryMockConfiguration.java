package es.cca.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link ACCENTIDADPERSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class ACCENTIDADPERSearchRepositoryMockConfiguration {

    @MockBean
    private ACCENTIDADPERSearchRepository mockACCENTIDADPERSearchRepository;

}
