package es.cca.web.rest;

import es.cca.TCuApp;
import es.cca.domain.ACCENTIDADDF;
import es.cca.repository.ACCENTIDADDFRepository;
import es.cca.repository.search.ACCENTIDADDFSearchRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link ACCENTIDADDFResource} REST controller.
 */
@SpringBootTest(classes = TCuApp.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@WithMockUser
public class ACCENTIDADDFResourceIT {

    private static final Long DEFAULT_I_DENTIDAD = 1L;
    private static final Long UPDATED_I_DENTIDAD = 2L;

    private static final String DEFAULT_N_OMBRE = "AAAAAAAAAA";
    private static final String UPDATED_N_OMBRE = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_F_ECHACONSTITUCION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHACONSTITUCION = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_F_ECHAEXTINCION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHAEXTINCION = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_D_OMICILIO = "AAAAAAAAAA";
    private static final String UPDATED_D_OMICILIO = "BBBBBBBBBB";

    private static final String DEFAULT_C_ODIGOPOSTAL = "AAAAAAAAAA";
    private static final String UPDATED_C_ODIGOPOSTAL = "BBBBBBBBBB";

    private static final String DEFAULT_T_ELEFONO = "AAAAAAAAAA";
    private static final String UPDATED_T_ELEFONO = "BBBBBBBBBB";

    private static final String DEFAULT_E_MAIL = "AAAAAAAAAA";
    private static final String UPDATED_E_MAIL = "BBBBBBBBBB";

    private static final String DEFAULT_D_EU = "AAAAAAAAAA";
    private static final String UPDATED_D_EU = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_F_ECHAALTAAPP = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHAALTAAPP = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_F_ECHABAJAAPP = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHABAJAAPP = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_F_ECHAALTACENSO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHAALTACENSO = LocalDate.now(ZoneId.systemDefault());

    private static final LocalDate DEFAULT_F_ECHABAJACENSO = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHABAJACENSO = LocalDate.now(ZoneId.systemDefault());

    private static final Long DEFAULT_N_UMEROVERSION = 1L;
    private static final Long UPDATED_N_UMEROVERSION = 2L;

    private static final LocalDate DEFAULT_F_ECHAVERSION = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_F_ECHAVERSION = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ACCENTIDADDFRepository aCCENTIDADDFRepository;

    /**
     * This repository is mocked in the es.cca.repository.search test package.
     *
     * @see es.cca.repository.search.ACCENTIDADDFSearchRepositoryMockConfiguration
     */
    @Autowired
    private ACCENTIDADDFSearchRepository mockACCENTIDADDFSearchRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restACCENTIDADDFMockMvc;

    private ACCENTIDADDF aCCENTIDADDF;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ACCENTIDADDF createEntity(EntityManager em) {
        ACCENTIDADDF aCCENTIDADDF = new ACCENTIDADDF()
            .iDENTIDAD(DEFAULT_I_DENTIDAD)
            .nOMBRE(DEFAULT_N_OMBRE)
            .fECHACONSTITUCION(DEFAULT_F_ECHACONSTITUCION)
            .fECHAEXTINCION(DEFAULT_F_ECHAEXTINCION)
            .dOMICILIO(DEFAULT_D_OMICILIO)
            .cODIGOPOSTAL(DEFAULT_C_ODIGOPOSTAL)
            .tELEFONO(DEFAULT_T_ELEFONO)
            .eMAIL(DEFAULT_E_MAIL)
            .dEU(DEFAULT_D_EU)
            .fECHAALTAAPP(DEFAULT_F_ECHAALTAAPP)
            .fECHABAJAAPP(DEFAULT_F_ECHABAJAAPP)
            .fECHAALTACENSO(DEFAULT_F_ECHAALTACENSO)
            .fECHABAJACENSO(DEFAULT_F_ECHABAJACENSO)
            .nUMEROVERSION(DEFAULT_N_UMEROVERSION)
            .fECHAVERSION(DEFAULT_F_ECHAVERSION);
        return aCCENTIDADDF;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static ACCENTIDADDF createUpdatedEntity(EntityManager em) {
        ACCENTIDADDF aCCENTIDADDF = new ACCENTIDADDF()
            .iDENTIDAD(UPDATED_I_DENTIDAD)
            .nOMBRE(UPDATED_N_OMBRE)
            .fECHACONSTITUCION(UPDATED_F_ECHACONSTITUCION)
            .fECHAEXTINCION(UPDATED_F_ECHAEXTINCION)
            .dOMICILIO(UPDATED_D_OMICILIO)
            .cODIGOPOSTAL(UPDATED_C_ODIGOPOSTAL)
            .tELEFONO(UPDATED_T_ELEFONO)
            .eMAIL(UPDATED_E_MAIL)
            .dEU(UPDATED_D_EU)
            .fECHAALTAAPP(UPDATED_F_ECHAALTAAPP)
            .fECHABAJAAPP(UPDATED_F_ECHABAJAAPP)
            .fECHAALTACENSO(UPDATED_F_ECHAALTACENSO)
            .fECHABAJACENSO(UPDATED_F_ECHABAJACENSO)
            .nUMEROVERSION(UPDATED_N_UMEROVERSION)
            .fECHAVERSION(UPDATED_F_ECHAVERSION);
        return aCCENTIDADDF;
    }

    @BeforeEach
    public void initTest() {
        aCCENTIDADDF = createEntity(em);
    }

    @Test
    @Transactional
    public void createACCENTIDADDF() throws Exception {
        int databaseSizeBeforeCreate = aCCENTIDADDFRepository.findAll().size();

        // Create the ACCENTIDADDF
        restACCENTIDADDFMockMvc.perform(post("/api/accentidaddfs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADDF)))
            .andExpect(status().isCreated());

        // Validate the ACCENTIDADDF in the database
        List<ACCENTIDADDF> aCCENTIDADDFList = aCCENTIDADDFRepository.findAll();
        assertThat(aCCENTIDADDFList).hasSize(databaseSizeBeforeCreate + 1);
        ACCENTIDADDF testACCENTIDADDF = aCCENTIDADDFList.get(aCCENTIDADDFList.size() - 1);
        assertThat(testACCENTIDADDF.getiDENTIDAD()).isEqualTo(DEFAULT_I_DENTIDAD);
        assertThat(testACCENTIDADDF.getnOMBRE()).isEqualTo(DEFAULT_N_OMBRE);
        assertThat(testACCENTIDADDF.getfECHACONSTITUCION()).isEqualTo(DEFAULT_F_ECHACONSTITUCION);
        assertThat(testACCENTIDADDF.getfECHAEXTINCION()).isEqualTo(DEFAULT_F_ECHAEXTINCION);
        assertThat(testACCENTIDADDF.getdOMICILIO()).isEqualTo(DEFAULT_D_OMICILIO);
        assertThat(testACCENTIDADDF.getcODIGOPOSTAL()).isEqualTo(DEFAULT_C_ODIGOPOSTAL);
        assertThat(testACCENTIDADDF.gettELEFONO()).isEqualTo(DEFAULT_T_ELEFONO);
        assertThat(testACCENTIDADDF.geteMAIL()).isEqualTo(DEFAULT_E_MAIL);
        assertThat(testACCENTIDADDF.getdEU()).isEqualTo(DEFAULT_D_EU);
        assertThat(testACCENTIDADDF.getfECHAALTAAPP()).isEqualTo(DEFAULT_F_ECHAALTAAPP);
        assertThat(testACCENTIDADDF.getfECHABAJAAPP()).isEqualTo(DEFAULT_F_ECHABAJAAPP);
        assertThat(testACCENTIDADDF.getfECHAALTACENSO()).isEqualTo(DEFAULT_F_ECHAALTACENSO);
        assertThat(testACCENTIDADDF.getfECHABAJACENSO()).isEqualTo(DEFAULT_F_ECHABAJACENSO);
        assertThat(testACCENTIDADDF.getnUMEROVERSION()).isEqualTo(DEFAULT_N_UMEROVERSION);
        assertThat(testACCENTIDADDF.getfECHAVERSION()).isEqualTo(DEFAULT_F_ECHAVERSION);

        // Validate the ACCENTIDADDF in Elasticsearch
        verify(mockACCENTIDADDFSearchRepository, times(1)).save(testACCENTIDADDF);
    }

    @Test
    @Transactional
    public void createACCENTIDADDFWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = aCCENTIDADDFRepository.findAll().size();

        // Create the ACCENTIDADDF with an existing ID
        aCCENTIDADDF.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restACCENTIDADDFMockMvc.perform(post("/api/accentidaddfs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADDF)))
            .andExpect(status().isBadRequest());

        // Validate the ACCENTIDADDF in the database
        List<ACCENTIDADDF> aCCENTIDADDFList = aCCENTIDADDFRepository.findAll();
        assertThat(aCCENTIDADDFList).hasSize(databaseSizeBeforeCreate);

        // Validate the ACCENTIDADDF in Elasticsearch
        verify(mockACCENTIDADDFSearchRepository, times(0)).save(aCCENTIDADDF);
    }


    @Test
    @Transactional
    public void getAllACCENTIDADDFS() throws Exception {
        // Initialize the database
        aCCENTIDADDFRepository.saveAndFlush(aCCENTIDADDF);

        // Get all the aCCENTIDADDFList
        restACCENTIDADDFMockMvc.perform(get("/api/accentidaddfs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aCCENTIDADDF.getId().intValue())))
            .andExpect(jsonPath("$.[*].iDENTIDAD").value(hasItem(DEFAULT_I_DENTIDAD.intValue())))
            .andExpect(jsonPath("$.[*].nOMBRE").value(hasItem(DEFAULT_N_OMBRE)))
            .andExpect(jsonPath("$.[*].fECHACONSTITUCION").value(hasItem(DEFAULT_F_ECHACONSTITUCION.toString())))
            .andExpect(jsonPath("$.[*].fECHAEXTINCION").value(hasItem(DEFAULT_F_ECHAEXTINCION.toString())))
            .andExpect(jsonPath("$.[*].dOMICILIO").value(hasItem(DEFAULT_D_OMICILIO)))
            .andExpect(jsonPath("$.[*].cODIGOPOSTAL").value(hasItem(DEFAULT_C_ODIGOPOSTAL)))
            .andExpect(jsonPath("$.[*].tELEFONO").value(hasItem(DEFAULT_T_ELEFONO)))
            .andExpect(jsonPath("$.[*].eMAIL").value(hasItem(DEFAULT_E_MAIL)))
            .andExpect(jsonPath("$.[*].dEU").value(hasItem(DEFAULT_D_EU)))
            .andExpect(jsonPath("$.[*].fECHAALTAAPP").value(hasItem(DEFAULT_F_ECHAALTAAPP.toString())))
            .andExpect(jsonPath("$.[*].fECHABAJAAPP").value(hasItem(DEFAULT_F_ECHABAJAAPP.toString())))
            .andExpect(jsonPath("$.[*].fECHAALTACENSO").value(hasItem(DEFAULT_F_ECHAALTACENSO.toString())))
            .andExpect(jsonPath("$.[*].fECHABAJACENSO").value(hasItem(DEFAULT_F_ECHABAJACENSO.toString())))
            .andExpect(jsonPath("$.[*].nUMEROVERSION").value(hasItem(DEFAULT_N_UMEROVERSION.intValue())))
            .andExpect(jsonPath("$.[*].fECHAVERSION").value(hasItem(DEFAULT_F_ECHAVERSION.toString())));
    }
    
    @Test
    @Transactional
    public void getACCENTIDADDF() throws Exception {
        // Initialize the database
        aCCENTIDADDFRepository.saveAndFlush(aCCENTIDADDF);

        // Get the aCCENTIDADDF
        restACCENTIDADDFMockMvc.perform(get("/api/accentidaddfs/{id}", aCCENTIDADDF.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(aCCENTIDADDF.getId().intValue()))
            .andExpect(jsonPath("$.iDENTIDAD").value(DEFAULT_I_DENTIDAD.intValue()))
            .andExpect(jsonPath("$.nOMBRE").value(DEFAULT_N_OMBRE))
            .andExpect(jsonPath("$.fECHACONSTITUCION").value(DEFAULT_F_ECHACONSTITUCION.toString()))
            .andExpect(jsonPath("$.fECHAEXTINCION").value(DEFAULT_F_ECHAEXTINCION.toString()))
            .andExpect(jsonPath("$.dOMICILIO").value(DEFAULT_D_OMICILIO))
            .andExpect(jsonPath("$.cODIGOPOSTAL").value(DEFAULT_C_ODIGOPOSTAL))
            .andExpect(jsonPath("$.tELEFONO").value(DEFAULT_T_ELEFONO))
            .andExpect(jsonPath("$.eMAIL").value(DEFAULT_E_MAIL))
            .andExpect(jsonPath("$.dEU").value(DEFAULT_D_EU))
            .andExpect(jsonPath("$.fECHAALTAAPP").value(DEFAULT_F_ECHAALTAAPP.toString()))
            .andExpect(jsonPath("$.fECHABAJAAPP").value(DEFAULT_F_ECHABAJAAPP.toString()))
            .andExpect(jsonPath("$.fECHAALTACENSO").value(DEFAULT_F_ECHAALTACENSO.toString()))
            .andExpect(jsonPath("$.fECHABAJACENSO").value(DEFAULT_F_ECHABAJACENSO.toString()))
            .andExpect(jsonPath("$.nUMEROVERSION").value(DEFAULT_N_UMEROVERSION.intValue()))
            .andExpect(jsonPath("$.fECHAVERSION").value(DEFAULT_F_ECHAVERSION.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingACCENTIDADDF() throws Exception {
        // Get the aCCENTIDADDF
        restACCENTIDADDFMockMvc.perform(get("/api/accentidaddfs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateACCENTIDADDF() throws Exception {
        // Initialize the database
        aCCENTIDADDFRepository.saveAndFlush(aCCENTIDADDF);

        int databaseSizeBeforeUpdate = aCCENTIDADDFRepository.findAll().size();

        // Update the aCCENTIDADDF
        ACCENTIDADDF updatedACCENTIDADDF = aCCENTIDADDFRepository.findById(aCCENTIDADDF.getId()).get();
        // Disconnect from session so that the updates on updatedACCENTIDADDF are not directly saved in db
        em.detach(updatedACCENTIDADDF);
        updatedACCENTIDADDF
            .iDENTIDAD(UPDATED_I_DENTIDAD)
            .nOMBRE(UPDATED_N_OMBRE)
            .fECHACONSTITUCION(UPDATED_F_ECHACONSTITUCION)
            .fECHAEXTINCION(UPDATED_F_ECHAEXTINCION)
            .dOMICILIO(UPDATED_D_OMICILIO)
            .cODIGOPOSTAL(UPDATED_C_ODIGOPOSTAL)
            .tELEFONO(UPDATED_T_ELEFONO)
            .eMAIL(UPDATED_E_MAIL)
            .dEU(UPDATED_D_EU)
            .fECHAALTAAPP(UPDATED_F_ECHAALTAAPP)
            .fECHABAJAAPP(UPDATED_F_ECHABAJAAPP)
            .fECHAALTACENSO(UPDATED_F_ECHAALTACENSO)
            .fECHABAJACENSO(UPDATED_F_ECHABAJACENSO)
            .nUMEROVERSION(UPDATED_N_UMEROVERSION)
            .fECHAVERSION(UPDATED_F_ECHAVERSION);

        restACCENTIDADDFMockMvc.perform(put("/api/accentidaddfs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedACCENTIDADDF)))
            .andExpect(status().isOk());

        // Validate the ACCENTIDADDF in the database
        List<ACCENTIDADDF> aCCENTIDADDFList = aCCENTIDADDFRepository.findAll();
        assertThat(aCCENTIDADDFList).hasSize(databaseSizeBeforeUpdate);
        ACCENTIDADDF testACCENTIDADDF = aCCENTIDADDFList.get(aCCENTIDADDFList.size() - 1);
        assertThat(testACCENTIDADDF.getiDENTIDAD()).isEqualTo(UPDATED_I_DENTIDAD);
        assertThat(testACCENTIDADDF.getnOMBRE()).isEqualTo(UPDATED_N_OMBRE);
        assertThat(testACCENTIDADDF.getfECHACONSTITUCION()).isEqualTo(UPDATED_F_ECHACONSTITUCION);
        assertThat(testACCENTIDADDF.getfECHAEXTINCION()).isEqualTo(UPDATED_F_ECHAEXTINCION);
        assertThat(testACCENTIDADDF.getdOMICILIO()).isEqualTo(UPDATED_D_OMICILIO);
        assertThat(testACCENTIDADDF.getcODIGOPOSTAL()).isEqualTo(UPDATED_C_ODIGOPOSTAL);
        assertThat(testACCENTIDADDF.gettELEFONO()).isEqualTo(UPDATED_T_ELEFONO);
        assertThat(testACCENTIDADDF.geteMAIL()).isEqualTo(UPDATED_E_MAIL);
        assertThat(testACCENTIDADDF.getdEU()).isEqualTo(UPDATED_D_EU);
        assertThat(testACCENTIDADDF.getfECHAALTAAPP()).isEqualTo(UPDATED_F_ECHAALTAAPP);
        assertThat(testACCENTIDADDF.getfECHABAJAAPP()).isEqualTo(UPDATED_F_ECHABAJAAPP);
        assertThat(testACCENTIDADDF.getfECHAALTACENSO()).isEqualTo(UPDATED_F_ECHAALTACENSO);
        assertThat(testACCENTIDADDF.getfECHABAJACENSO()).isEqualTo(UPDATED_F_ECHABAJACENSO);
        assertThat(testACCENTIDADDF.getnUMEROVERSION()).isEqualTo(UPDATED_N_UMEROVERSION);
        assertThat(testACCENTIDADDF.getfECHAVERSION()).isEqualTo(UPDATED_F_ECHAVERSION);

        // Validate the ACCENTIDADDF in Elasticsearch
        verify(mockACCENTIDADDFSearchRepository, times(1)).save(testACCENTIDADDF);
    }

    @Test
    @Transactional
    public void updateNonExistingACCENTIDADDF() throws Exception {
        int databaseSizeBeforeUpdate = aCCENTIDADDFRepository.findAll().size();

        // Create the ACCENTIDADDF

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restACCENTIDADDFMockMvc.perform(put("/api/accentidaddfs")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(aCCENTIDADDF)))
            .andExpect(status().isBadRequest());

        // Validate the ACCENTIDADDF in the database
        List<ACCENTIDADDF> aCCENTIDADDFList = aCCENTIDADDFRepository.findAll();
        assertThat(aCCENTIDADDFList).hasSize(databaseSizeBeforeUpdate);

        // Validate the ACCENTIDADDF in Elasticsearch
        verify(mockACCENTIDADDFSearchRepository, times(0)).save(aCCENTIDADDF);
    }

    @Test
    @Transactional
    public void deleteACCENTIDADDF() throws Exception {
        // Initialize the database
        aCCENTIDADDFRepository.saveAndFlush(aCCENTIDADDF);

        int databaseSizeBeforeDelete = aCCENTIDADDFRepository.findAll().size();

        // Delete the aCCENTIDADDF
        restACCENTIDADDFMockMvc.perform(delete("/api/accentidaddfs/{id}", aCCENTIDADDF.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<ACCENTIDADDF> aCCENTIDADDFList = aCCENTIDADDFRepository.findAll();
        assertThat(aCCENTIDADDFList).hasSize(databaseSizeBeforeDelete - 1);

        // Validate the ACCENTIDADDF in Elasticsearch
        verify(mockACCENTIDADDFSearchRepository, times(1)).deleteById(aCCENTIDADDF.getId());
    }

    @Test
    @Transactional
    public void searchACCENTIDADDF() throws Exception {
        // Initialize the database
        aCCENTIDADDFRepository.saveAndFlush(aCCENTIDADDF);
        when(mockACCENTIDADDFSearchRepository.search(queryStringQuery("id:" + aCCENTIDADDF.getId()), PageRequest.of(0, 20)))
            .thenReturn(new PageImpl<>(Collections.singletonList(aCCENTIDADDF), PageRequest.of(0, 1), 1));
        // Search the aCCENTIDADDF
        restACCENTIDADDFMockMvc.perform(get("/api/_search/accentidaddfs?query=id:" + aCCENTIDADDF.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(aCCENTIDADDF.getId().intValue())))
            .andExpect(jsonPath("$.[*].iDENTIDAD").value(hasItem(DEFAULT_I_DENTIDAD.intValue())))
            .andExpect(jsonPath("$.[*].nOMBRE").value(hasItem(DEFAULT_N_OMBRE)))
            .andExpect(jsonPath("$.[*].fECHACONSTITUCION").value(hasItem(DEFAULT_F_ECHACONSTITUCION.toString())))
            .andExpect(jsonPath("$.[*].fECHAEXTINCION").value(hasItem(DEFAULT_F_ECHAEXTINCION.toString())))
            .andExpect(jsonPath("$.[*].dOMICILIO").value(hasItem(DEFAULT_D_OMICILIO)))
            .andExpect(jsonPath("$.[*].cODIGOPOSTAL").value(hasItem(DEFAULT_C_ODIGOPOSTAL)))
            .andExpect(jsonPath("$.[*].tELEFONO").value(hasItem(DEFAULT_T_ELEFONO)))
            .andExpect(jsonPath("$.[*].eMAIL").value(hasItem(DEFAULT_E_MAIL)))
            .andExpect(jsonPath("$.[*].dEU").value(hasItem(DEFAULT_D_EU)))
            .andExpect(jsonPath("$.[*].fECHAALTAAPP").value(hasItem(DEFAULT_F_ECHAALTAAPP.toString())))
            .andExpect(jsonPath("$.[*].fECHABAJAAPP").value(hasItem(DEFAULT_F_ECHABAJAAPP.toString())))
            .andExpect(jsonPath("$.[*].fECHAALTACENSO").value(hasItem(DEFAULT_F_ECHAALTACENSO.toString())))
            .andExpect(jsonPath("$.[*].fECHABAJACENSO").value(hasItem(DEFAULT_F_ECHABAJACENSO.toString())))
            .andExpect(jsonPath("$.[*].nUMEROVERSION").value(hasItem(DEFAULT_N_UMEROVERSION.intValue())))
            .andExpect(jsonPath("$.[*].fECHAVERSION").value(hasItem(DEFAULT_F_ECHAVERSION.toString())));
    }
}
