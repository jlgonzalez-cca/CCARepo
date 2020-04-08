package es.cca.web.rest;

import es.cca.domain.DCCCARGOENT;
import es.cca.repository.DCCCARGOENTRepository;
import es.cca.repository.search.DCCCARGOENTSearchRepository;
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
 * REST controller for managing {@link es.cca.domain.DCCCARGOENT}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class DCCCARGOENTResource {

    private final Logger log = LoggerFactory.getLogger(DCCCARGOENTResource.class);

    private static final String ENTITY_NAME = "dCCCARGOENT";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final DCCCARGOENTRepository dCCCARGOENTRepository;

    private final DCCCARGOENTSearchRepository dCCCARGOENTSearchRepository;

    public DCCCARGOENTResource(DCCCARGOENTRepository dCCCARGOENTRepository, DCCCARGOENTSearchRepository dCCCARGOENTSearchRepository) {
        this.dCCCARGOENTRepository = dCCCARGOENTRepository;
        this.dCCCARGOENTSearchRepository = dCCCARGOENTSearchRepository;
    }

    /**
     * {@code POST  /dcccargoents} : Create a new dCCCARGOENT.
     *
     * @param dCCCARGOENT the dCCCARGOENT to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new dCCCARGOENT, or with status {@code 400 (Bad Request)} if the dCCCARGOENT has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/dcccargoents")
    public ResponseEntity<DCCCARGOENT> createDCCCARGOENT(@RequestBody DCCCARGOENT dCCCARGOENT) throws URISyntaxException {
        log.debug("REST request to save DCCCARGOENT : {}", dCCCARGOENT);
        if (dCCCARGOENT.getId() != null) {
            throw new BadRequestAlertException("A new dCCCARGOENT cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DCCCARGOENT result = dCCCARGOENTRepository.save(dCCCARGOENT);
        dCCCARGOENTSearchRepository.save(result);
        return ResponseEntity.created(new URI("/api/dcccargoents/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /dcccargoents} : Updates an existing dCCCARGOENT.
     *
     * @param dCCCARGOENT the dCCCARGOENT to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated dCCCARGOENT,
     * or with status {@code 400 (Bad Request)} if the dCCCARGOENT is not valid,
     * or with status {@code 500 (Internal Server Error)} if the dCCCARGOENT couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/dcccargoents")
    public ResponseEntity<DCCCARGOENT> updateDCCCARGOENT(@RequestBody DCCCARGOENT dCCCARGOENT) throws URISyntaxException {
        log.debug("REST request to update DCCCARGOENT : {}", dCCCARGOENT);
        if (dCCCARGOENT.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DCCCARGOENT result = dCCCARGOENTRepository.save(dCCCARGOENT);
        dCCCARGOENTSearchRepository.save(result);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, dCCCARGOENT.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /dcccargoents} : get all the dCCCARGOENTS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of dCCCARGOENTS in body.
     */
    @GetMapping("/dcccargoents")
    public ResponseEntity<List<DCCCARGOENT>> getAllDCCCARGOENTS(Pageable pageable) {
        log.debug("REST request to get a page of DCCCARGOENTS");
        Page<DCCCARGOENT> page = dCCCARGOENTRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /dcccargoents/:id} : get the "id" dCCCARGOENT.
     *
     * @param id the id of the dCCCARGOENT to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the dCCCARGOENT, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/dcccargoents/{id}")
    public ResponseEntity<DCCCARGOENT> getDCCCARGOENT(@PathVariable Long id) {
        log.debug("REST request to get DCCCARGOENT : {}", id);
        Optional<DCCCARGOENT> dCCCARGOENT = dCCCARGOENTRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(dCCCARGOENT);
    }

    /**
     * {@code DELETE  /dcccargoents/:id} : delete the "id" dCCCARGOENT.
     *
     * @param id the id of the dCCCARGOENT to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/dcccargoents/{id}")
    public ResponseEntity<Void> deleteDCCCARGOENT(@PathVariable Long id) {
        log.debug("REST request to delete DCCCARGOENT : {}", id);
        dCCCARGOENTRepository.deleteById(id);
        dCCCARGOENTSearchRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }

    /**
     * {@code SEARCH  /_search/dcccargoents?query=:query} : search for the dCCCARGOENT corresponding
     * to the query.
     *
     * @param query the query of the dCCCARGOENT search.
     * @param pageable the pagination information.
     * @return the result of the search.
     */
    @GetMapping("/_search/dcccargoents")
    public ResponseEntity<List<DCCCARGOENT>> searchDCCCARGOENTS(@RequestParam String query, Pageable pageable) {
        log.debug("REST request to search for a page of DCCCARGOENTS for query {}", query);
        Page<DCCCARGOENT> page = dCCCARGOENTSearchRepository.search(queryStringQuery(query), pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }
}
