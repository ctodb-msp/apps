package cn.ctodb.msp.apps.repository;

import cn.ctodb.msp.apps.domain.AppApps;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AppApps entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppAppsRepository extends JpaRepository<AppApps, Long> {

}
