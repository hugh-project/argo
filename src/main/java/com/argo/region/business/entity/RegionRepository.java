package com.argo.region.business.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 11:02
 *
 * @author hugh
 */
public interface RegionRepository extends JpaRepository<Region,String> {
    @Transactional
    @Query("update Region r set r.cfmTime = ?2 where r.regionId = ?1")
    @Modifying
    void changeCFMtime(String id, Timestamp CFMtime);
}
