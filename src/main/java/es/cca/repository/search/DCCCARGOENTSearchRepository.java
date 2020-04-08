package es.cca.repository.search;

import es.cca.domain.DCCCARGOENT;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link DCCCARGOENT} entity.
 */
public interface DCCCARGOENTSearchRepository extends ElasticsearchRepository<DCCCARGOENT, Long> {
}
