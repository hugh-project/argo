package com.argo.region.business.dao;

import com.argo.region.business.entity.Region;
import com.argo.region.business.entity.RegionRepository;
import com.argo.region.business.model.ResMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 11:19
 *
 * @author hugh
 */
@Component
public class RegionDao {
    @Autowired
    private RegionRepository regionRepository;
    public ResMessage addRegion(Region region){
        try {
            regionRepository.save(region);
        }catch (Exception e){
            return new ResMessage(false,e.getMessage());
        }

        return new ResMessage(true,"区域添加成功！");
    }
    public Boolean checkRegionById(String id){
        Optional<Region> byId = regionRepository.findById(id);
        return byId.isPresent();
    }
    public void changeCFMtime(String id, Timestamp CFMtime){
    regionRepository.changeCFMtime(id,CFMtime);
    }
}
