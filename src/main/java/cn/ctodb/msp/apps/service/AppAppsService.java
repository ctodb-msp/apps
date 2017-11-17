package cn.ctodb.msp.apps.service;

import cn.ctodb.msp.apps.service.dto.AppAppsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing AppApps.
 */
public interface AppAppsService {

    /**
     * Save a appApps.
     *
     * @param appAppsDTO the entity to save
     * @return the persisted entity
     */
    AppAppsDTO save(AppAppsDTO appAppsDTO);

    /**
     *  Get all the appApps.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<AppAppsDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" appApps.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    AppAppsDTO findOne(Long id);

    /**
     *  Delete the "id" appApps.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
