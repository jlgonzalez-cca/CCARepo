package es.cca.repository;

import es.cca.domain.ACCENTIDADPER;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the ACCENTIDADPER entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ACCENTIDADPERRepository extends JpaRepository<ACCENTIDADPER, Long> {
}
