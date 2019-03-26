package com.argo.region.business.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <ul>
 * <li>公司名称 : 力微和</li>
 * <li>文件名称 : com.argo.region.business.api.RegionManagerApi</li>
 * <li>创建时间 : 2019年03月26日</li>
 * <li>描    述 :
 * <p>
 * </ul>
 *
 * @author XiaoLong.Tu
 * @since 1.0.0
 */
@Api(value = "区域API", description = "管理行政区域主数据")
public interface RegionManagerApi {

    @ApiOperation(httpMethod = "POST" ,value = "添加区域", nickname = "addRegion", notes = "添加新的行政区域主数据")
    @RequestMapping(value = "/addRegion", produces = "application/json",  method = RequestMethod.POST)
    ResponseEntity addRegion();
}
