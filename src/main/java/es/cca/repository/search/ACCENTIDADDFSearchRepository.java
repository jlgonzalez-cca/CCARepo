package es.cca.repository.search;

import es.cca.domain.ACCENTIDADDF;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * Spring Data Elasticsearch repository for the {@link ACCENTIDADDF} entity.
 */
public interface ACCENTIDADDFSearchRepository extends ElasticsearchRepository<ACCENTIDADDF, Long> {
}
