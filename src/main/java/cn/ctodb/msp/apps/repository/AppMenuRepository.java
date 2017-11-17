package cn.ctodb.msp.apps.repository;

import cn.ctodb.msp.apps.domain.AppMenu;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the AppMenu entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AppMenuRepository extends JpaRepository<AppMenu, Long> {

}
