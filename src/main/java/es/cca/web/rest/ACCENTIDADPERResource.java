package es.cca.web.rest;

import es.cca.domain.ACCENTIDADPER;
import es.cca.repository.ACCENTIDADPERRepository;
import es.cca.repository.search.ACCENTIDADPERSearchRepository;
import es.cca.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.elasticsearch.index.query.QueryBuilders.*;

/**
 * REST controller for managing {@link es.cca.domain.ACCENTIDADPER}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ACCENTIDADPERResource {

    private final Logger log = LoggerFactory.getLogger(ACCENTIDADPERResource.class);

    private static final String ENTITY_NAME = "aCCENTIDADPER";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ACCENTIDADPERRepository aCCENTIDADPERRepository;

    private final ACCENTIDADPERSearchRepository aCCENTIDADPERSearchRepository;

    public ACCENTIDADPERResource(ACCENTIDADPERRepository aCCENTIDADPERRepository, ACCENTIDADPERSearchRepository aCCENTIDADPERSearchRepository) {
        this.aCCENTIDADPERRepository = aCCENTIDADPERRepository;
        this.aCCENTIDADPERSearchRepository = aCCENTIDADPERSearchRepository;
    }

    /**
     * {@code POST  /accentidadpers} : Create a new aCCENTIDADPER.
     *
     * @param aCCENTIDADPER the aCCENTIDADPER to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new aCCENTIDADPER, or with status {@code 400 (Bad Request)} if the aCCENTIDADPER has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/accentidadpers")
    public ResponseEntity<ACCENTIDADPER> createACCENTIDADPER(@RequestBody ACCENTIDADPER aCCENTIDADPER) throws URISyntaxException {
        log.debug("REST request to save ACCENTIDADPER : {}", aCCENTIDADPER);
        if (aCCENTIDADPER.getId() != null) {
            throw new BadRequestAlertException("A new aCCENTIDADPER cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ACCENTIDADPER result = aCCENTIDADPERRepository.save(aCCENTIDADPER);
        aCCENTIDADPERSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/accentidadpers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /accentidadpers} : Updates an existing aCCENTIDADPER.
     *
     * @param aCCENTIDADPER the aCCENTIDADPER to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aCCENTIDADPER,
     * or with status {@code 400 (Bad Request)} if the aCCENTIDADPER is not valid,
     * or with status {@code 500 (Internal Server Error)} if the aCCENTIDADPER couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/accentidadpers")
    public ResponseEntity<ACCENTIDADPER> updateACCENTIDADPER(@RequestBody ACCENTIDADPER aCCENTIDADPER) throws URISyntaxException {
        log.debug("REST request to update ACCENTIDADPER : {}", aCCENTIDADPER);
        if (aCCENTIDADPER.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ACCENTIDADPER result = aCCENTIDADPERRepository.save(aCCENTIDADPER);
        aCCENTIDADPERSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, aCCENTIDADPER.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /accentidadpers} : get all the aCCENTIDADPERS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of aCCENTIDADPERS in body.
     */
    @GetMapping("/accentidadpers")
    public ResponseEntity<List<ACCENTIDADPER>> getAllACCENTIDADPERS(Pageable pageable) {
        log.debug("REST request to get a page of ACCENTIDADPERS");
        Page<ACCENTIDADPER> page = aCCENTIDADPERRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /accentidadpers/:id} : get the "id" aCCENTIDADPER.
     *
     * @param id the id of the aCCENTIDADPER to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the aCCENTIDADPER, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/accentidadpers/{id}")
    public ResponseEntity<ACCENTIDADPER> getACCENTIDADPER(@PathVariable Long id) {
        log.debug("REST request to get ACCENTIDADPER : {}", id);
        Optional<ACCENTIDADPER> aCCENTIDADPER = aCCENTIDADPERRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(aCCENTIDADPER);
    }

    /**
     * {@code DELETE  /accentidadpers/:id} : delete the "id" aCCENTIDADPER.
     *
     * @param id the id of the aCCENTIDADPER to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/accentidadpers/{id}")
    public ResponseEntity<Void> deleteACCENTIDADPER(@PathVariable Long id) {
        log.debug("REST request to delete ACCENTIDADPER : {}", id);
        aCCENTIDADPERRepository.deleteById(id);
        aCCENTIDADPERSearchRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/accentidadpers?query=:query} : search for the aCCENTIDADPER corresponding
     * to the query.
     *
     * @param query the query of the aCCENTIDADPER search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/accentidadpers")
    public ResponseEntity<List<ACCENTIDADPER>> searchACCENTIDADPERS(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of ACCENTIDADPERS for query {}", query);
        Page<ACCENTIDADPER> page = aCCENTIDADPERSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
