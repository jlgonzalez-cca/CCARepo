package es.cca.repository.search;

import es.cca.domain.ACCENTIDADPER;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ACCENTIDADPER} entity.
 */
public interface ACCENTIDADPERSearchRepository extends ElasticsearchRepository<ACCENTIDADPER, Long> {
}
