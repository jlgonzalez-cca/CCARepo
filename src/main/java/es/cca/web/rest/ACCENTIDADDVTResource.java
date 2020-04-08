package es.cca.web.rest;

import es.cca.domain.ACCENTIDADDVT;
import es.cca.repository.ACCENTIDADDVTRepository;
import es.cca.repository.search.ACCENTIDADDVTSearchRepository;
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
 * REST controller for managing {@link es.cca.domain.ACCENTIDADDVT}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class ACCENTIDADDVTResource {

    private final Logger log = LoggerFactory.getLogger(ACCENTIDADDVTResource.class);

    private static final String ENTITY_NAME = "aCCENTIDADDVT";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ACCENTIDADDVTRepository aCCENTIDADDVTRepository;

    private final ACCENTIDADDVTSearchRepository aCCENTIDADDVTSearchRepository;

    public ACCENTIDADDVTResource(ACCENTIDADDVTRepository aCCENTIDADDVTRepository, ACCENTIDADDVTSearchRepository aCCENTIDADDVTSearchRepository) {
        this.aCCENTIDADDVTRepository = aCCENTIDADDVTRepository;
        this.aCCENTIDADDVTSearchRepository = aCCENTIDADDVTSearchRepository;
    }

    /**
     * {@code POST  /accentidaddvts} : Create a new aCCENTIDADDVT.
     *
     * @param aCCENTIDADDVT the aCCENTIDADDVT to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new aCCENTIDADDVT, or with status {@code 400 (Bad Request)} if the aCCENTIDADDVT has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/accentidaddvts")
    public ResponseEntity<ACCENTIDADDVT> createACCENTIDADDVT(@RequestBody ACCENTIDADDVT aCCENTIDADDVT) throws URISyntaxException {
        log.debug("REST request to save ACCENTIDADDVT : {}", aCCENTIDADDVT);
        if (aCCENTIDADDVT.getId() != null) {
            throw new BadRequestAlertException("A new aCCENTIDADDVT cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ACCENTIDADDVT result = aCCENTIDADDVTRepository.save(aCCENTIDADDVT);
        aCCENTIDADDVTSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/accentidaddvts/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /accentidaddvts} : Updates an existing aCCENTIDADDVT.
     *
     * @param aCCENTIDADDVT the aCCENTIDADDVT to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated aCCENTIDADDVT,
     * or with status {@code 400 (Bad Request)} if the aCCENTIDADDVT is not valid,
     * or with status {@code 500 (Internal Server Error)} if the aCCENTIDADDVT couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/accentidaddvts")
    public ResponseEntity<ACCENTIDADDVT> updateACCENTIDADDVT(@RequestBody ACCENTIDADDVT aCCENTIDADDVT) throws URISyntaxException {
        log.debug("REST request to update ACCENTIDADDVT : {}", aCCENTIDADDVT);
        if (aCCENTIDADDVT.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        ACCENTIDADDVT result = aCCENTIDADDVTRepository.save(aCCENTIDADDVT);
        aCCENTIDADDVTSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, aCCENTIDADDVT.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /accentidaddvts} : get all the aCCENTIDADDVTS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of aCCENTIDADDVTS in body.
     */
    @GetMapping("/accentidaddvts")
    public ResponseEntity<List<ACCENTIDADDVT>> getAllACCENTIDADDVTS(Pageable pageable) {
        log.debug("REST request to get a page of ACCENTIDADDVTS");
        Page<ACCENTIDADDVT> page = aCCENTIDADDVTRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /accentidaddvts/:id} : get the "id" aCCENTIDADDVT.
     *
     * @param id the id of the aCCENTIDADDVT to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the aCCENTIDADDVT, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/accentidaddvts/{id}")
    public ResponseEntity<ACCENTIDADDVT> getACCENTIDADDVT(@PathVariable Long id) {
        log.debug("REST request to get ACCENTIDADDVT : {}", id);
        Optional<ACCENTIDADDVT> aCCENTIDADDVT = aCCENTIDADDVTRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(aCCENTIDADDVT);
    }

    /**
     * {@code DELETE  /accentidaddvts/:id} : delete the "id" aCCENTIDADDVT.
     *
     * @param id the id of the aCCENTIDADDVT to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/accentidaddvts/{id}")
    public ResponseEntity<Void> deleteACCENTIDADDVT(@PathVariable Long id) {
        log.debug("REST request to delete ACCENTIDADDVT : {}", id);
        aCCENTIDADDVTRepository.deleteById(id);
        aCCENTIDADDVTSearchRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/accentidaddvts?query=:query} : search for the aCCENTIDADDVT corresponding
     * to the query.
     *
     * @param query the query of the aCCENTIDADDVT search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/accentidaddvts")
    public ResponseEntity<List<ACCENTIDADDVT>> searchACCENTIDADDVTS(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of ACCENTIDADDVTS for query {}", query);
        Page<ACCENTIDADDVT> page = aCCENTIDADDVTSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
