package cn.ctodb.msp.apps.service.impl;

import cn.ctodb.msp.apps.service.AppMenuService;
import cn.ctodb.msp.apps.domain.AppMenu;
import cn.ctodb.msp.apps.repository.AppMenuRepository;
import cn.ctodb.msp.apps.service.dto.AppMenuDTO;
import cn.ctodb.msp.apps.service.mapper.AppMenuMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing AppMenu.
 */
@Service
@Transactional
public class AppMenuServiceImpl implements AppMenuService{

    private final Logger log = LoggerFactory.getLogger(AppMenuServiceImpl.class);

    private final AppMenuRepository appMenuRepository;

    private final AppMenuMapper appMenuMapper;

    public AppMenuServiceImpl(AppMenuRepository appMenuRepository, AppMenuMapper appMenuMapper) {
        this.appMenuRepository = appMenuRepository;
        this.appMenuMapper = appMenuMapper;
    }

    /**
     * Save a appMenu.
     *
     * @param appMenuDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AppMenuDTO save(AppMenuDTO appMenuDTO) {
        log.debug("Request to save AppMenu : {}", appMenuDTO);
        AppMenu appMenu = appMenuMapper.toEntity(appMenuDTO);
        appMenu = appMenuRepository.save(appMenu);
        return appMenuMapper.toDto(appMenu);
    }

    /**
     *  Get all the appMenus.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AppMenuDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppMenus");
        return appMenuRepository.findAll(pageable)
            .map(appMenuMapper::toDto);
    }

    /**
     *  Get one appMenu by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public AppMenuDTO findOne(Long id) {
        log.debug("Request to get AppMenu : {}", id);
        AppMenu appMenu = appMenuRepository.findOne(id);
        return appMenuMapper.toDto(appMenu);
    }

    /**
     *  Delete the  appMenu by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AppMenu : {}", id);
        appMenuRepository.delete(id);
    }
}
