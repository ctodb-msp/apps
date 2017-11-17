package cn.ctodb.msp.apps.service.impl;

import cn.ctodb.msp.apps.service.AppAppsService;
import cn.ctodb.msp.apps.domain.AppApps;
import cn.ctodb.msp.apps.repository.AppAppsRepository;
import cn.ctodb.msp.apps.service.dto.AppAppsDTO;
import cn.ctodb.msp.apps.service.mapper.AppAppsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing AppApps.
 */
@Service
@Transactional
public class AppAppsServiceImpl implements AppAppsService{

    private final Logger log = LoggerFactory.getLogger(AppAppsServiceImpl.class);

    private final AppAppsRepository appAppsRepository;

    private final AppAppsMapper appAppsMapper;

    public AppAppsServiceImpl(AppAppsRepository appAppsRepository, AppAppsMapper appAppsMapper) {
        this.appAppsRepository = appAppsRepository;
        this.appAppsMapper = appAppsMapper;
    }

    /**
     * Save a appApps.
     *
     * @param appAppsDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AppAppsDTO save(AppAppsDTO appAppsDTO) {
        log.debug("Request to save AppApps : {}", appAppsDTO);
        AppApps appApps = appAppsMapper.toEntity(appAppsDTO);
        appApps = appAppsRepository.save(appApps);
        return appAppsMapper.toDto(appApps);
    }

    /**
     *  Get all the appApps.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AppAppsDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppApps");
        return appAppsRepository.findAll(pageable)
            .map(appAppsMapper::toDto);
    }

    /**
     *  Get one appApps by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public AppAppsDTO findOne(Long id) {
        log.debug("Request to get AppApps : {}", id);
        AppApps appApps = appAppsRepository.findOne(id);
        return appAppsMapper.toDto(appApps);
    }

    /**
     *  Delete the  appApps by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AppApps : {}", id);
        appAppsRepository.delete(id);
    }
}
