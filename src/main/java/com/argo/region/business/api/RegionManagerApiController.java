package com.argo.region.business.api;

import com.argo.region.business.Service.RegionService;
import com.argo.region.business.model.RegionReq;
import com.argo.region.business.model.ResMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.regex.Pattern;

/**
 * <ul>
 * <li>公司名称 : 力微和</li>
 * <li>文件名称 : com.argo.region.business.api.RegionmanagerApiController</li>
 * <li>创建时间 : 2019年03月26日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author XiaoLong.Tu
 * @since 1.0.0
 */
@Controller
public class RegionManagerApiController implements RegionManagerApi {
    @Autowired
     private RegionService regionService;
    @Override
    public ResponseEntity<ResMessage> addRegion(RegionReq regionReq) {
        //id格式12位数字
        if(!Pattern.matches("^[0-9]{12}$",regionReq.getRegionId())){
            return ResponseEntity.ok(new ResMessage(false,"regionId应该位12位纯数字"));
        }
        //id是否重复
        if(regionService.checkRegion(regionReq.getRegionId())){
            return ResponseEntity.ok(new ResMessage(false,"regionId已存在"));
        }
        //是否启用，贫困位0或1
        if(!Pattern.matches("^[0-1]{0,1}$",regionReq.getIsActive().toString())){
            return ResponseEntity.ok(new ResMessage(false,"isActive应为0或1"));
        }
        if(!Pattern.matches("^[0-1]{0,1}$",regionReq.getIsPoor().toString())){
            return ResponseEntity.ok(new ResMessage(false,"isPoor应为0或1"));
        }
        //todo 数据校验
        return regionService.addRegion(regionReq);
    }
}
