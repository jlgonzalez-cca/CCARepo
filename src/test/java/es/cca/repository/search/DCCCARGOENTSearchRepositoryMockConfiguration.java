package es.cca.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link DCCCARGOENTSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class DCCCARGOENTSearchRepositoryMockConfiguration {

    @MockBean
    private DCCCARGOENTSearchRepository mockDCCCARGOENTSearchRepository;

}
