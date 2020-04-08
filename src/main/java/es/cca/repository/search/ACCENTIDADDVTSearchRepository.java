package es.cca.repository.search;

import es.cca.domain.ACCENTIDADDVT;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ACCENTIDADDVT} entity.
 */
public interface ACCENTIDADDVTSearchRepository extends ElasticsearchRepository<ACCENTIDADDVT, Long> {
}
