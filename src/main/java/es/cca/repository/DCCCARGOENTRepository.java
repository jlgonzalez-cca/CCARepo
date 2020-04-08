package es.cca.repository;

import es.cca.domain.DCCCARGOENT;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the DCCCARGOENT entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DCCCARGOENTRepository extends JpaRepository<DCCCARGOENT, Long> {
}
