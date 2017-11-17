package cn.ctodb.msp.apps.service;

import cn.ctodb.msp.apps.service.dto.AppMenuDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing AppMenu.
 */
public interface AppMenuService {

    /**
     * Save a appMenu.
     *
     * @param appMenuDTO the entity to save
     * @return the persisted entity
     */
    AppMenuDTO save(AppMenuDTO appMenuDTO);

    /**
     *  Get all the appMenus.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    Page<AppMenuDTO> findAll(Pageable pageable);

    /**
     *  Get the "id" appMenu.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    AppMenuDTO findOne(Long id);

    /**
     *  Delete the "id" appMenu.
     *
     *  @param id the id of the entity
     */
    void delete(Long id);
}
