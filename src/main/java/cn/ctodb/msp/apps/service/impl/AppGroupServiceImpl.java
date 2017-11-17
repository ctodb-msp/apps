package cn.ctodb.msp.apps.service.impl;

import cn.ctodb.msp.apps.service.AppGroupService;
import cn.ctodb.msp.apps.domain.AppGroup;
import cn.ctodb.msp.apps.repository.AppGroupRepository;
import cn.ctodb.msp.apps.service.dto.AppGroupDTO;
import cn.ctodb.msp.apps.service.mapper.AppGroupMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing AppGroup.
 */
@Service
@Transactional
public class AppGroupServiceImpl implements AppGroupService{

    private final Logger log = LoggerFactory.getLogger(AppGroupServiceImpl.class);

    private final AppGroupRepository appGroupRepository;

    private final AppGroupMapper appGroupMapper;

    public AppGroupServiceImpl(AppGroupRepository appGroupRepository, AppGroupMapper appGroupMapper) {
        this.appGroupRepository = appGroupRepository;
        this.appGroupMapper = appGroupMapper;
    }

    /**
     * Save a appGroup.
     *
     * @param appGroupDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public AppGroupDTO save(AppGroupDTO appGroupDTO) {
        log.debug("Request to save AppGroup : {}", appGroupDTO);
        AppGroup appGroup = appGroupMapper.toEntity(appGroupDTO);
        appGroup = appGroupRepository.save(appGroup);
        return appGroupMapper.toDto(appGroup);
    }

    /**
     *  Get all the appGroups.
     *
     *  @param pageable the pagination information
     *  @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<AppGroupDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AppGroups");
        return appGroupRepository.findAll(pageable)
            .map(appGroupMapper::toDto);
    }

    /**
     *  Get one appGroup by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public AppGroupDTO findOne(Long id) {
        log.debug("Request to get AppGroup : {}", id);
        AppGroup appGroup = appGroupRepository.findOne(id);
        return appGroupMapper.toDto(appGroup);
    }

    /**
     *  Delete the  appGroup by id.
     *
     *  @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete AppGroup : {}", id);
        appGroupRepository.delete(id);
    }
}
