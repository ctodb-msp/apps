package cn.ctodb.msp.apps.service;

import cn.ctodb.msp.apps.service.dto.AppGroupDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing AppGroup.
 */
public interface AppGroupService {

    /**
     * Save a appGroup.
     *
     * @param appGroupDTO the entity to save
     * @return the persisted entity
     */
    AppGroupDTO save(AppGroupDTO appGroupDTO);

    /**
     *  Get all the appGroups.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<AppGroupDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" appGroup.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    AppGroupDTO findOne(Long id);

    /**
     *  Delete the "id" appGroup.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
