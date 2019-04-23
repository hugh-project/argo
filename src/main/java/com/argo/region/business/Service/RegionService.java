package com.argo.region.business.Service;

import com.alibaba.fastjson.JSON;
import com.argo.region.business.configuration.AmqpConfiguration;
import com.argo.region.business.dao.RegionDao;
import com.argo.region.business.entity.Region;
import com.argo.region.business.model.RegionChangeEvent;
import com.argo.region.business.model.RegionPublishMessage;
import com.argo.region.business.model.RegionReq;
import com.argo.region.business.model.ResMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.LinkedList;

import static com.argo.region.business.configuration.AmqpConfiguration.regionCFMQueue;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 11:13
 *
 * @author hugh
 */
@Service
public class RegionService {
    @Autowired
    private RegionDao regionDao;
    @Autowired
    private RabbitTemplate template;
    @Autowired
    private PlatformTransactionManager txManager;
    @RabbitListener(queues = regionCFMQueue,containerFactory = "pointTaskContainerFactory")
    public void regionCFM(String msg){
        RegionPublishMessage regionPublishMessage = JSON.parseObject(msg, RegionPublishMessage.class);
        LinkedList<Region> regions = regionPublishMessage.getRegions();
        if(regions.size()>0){
            for (Region region : regions){
                String id = region.getRegionId();
                regionDao.changeCFMtime(id,new Timestamp(System.currentTimeMillis()));
            }
        }

    }
    public ResponseEntity<ResMessage> addRegion(RegionReq regionReq){
        Region region = initRegionEntity();
        region.setRegionId(regionReq.getRegionId());
        region.setLevel(regionReq.getLevel());
        if(regionReq.getLevel()>0){
            region.setLv1Code(region.getRegionId().substring(0,2));
            region.setLv1Name(regionReq.getLv1Name());
        }
        if(regionReq.getLevel()>1){
            region.setLv2Code(region.getRegionId().substring(2,4));
            region.setLv2Name(regionReq.getLv2Name());
        }
        if(regionReq.getLevel()>2){
            region.setLv3Code(region.getRegionId().substring(4,6));
            region.setLv3Name(regionReq.getLv3Name());
        }
        if(regionReq.getLevel()>3){
            region.setLv4Code(region.getRegionId().substring(6,9));
            region.setLv4Name(regionReq.getLv4Name());
        }
        if(regionReq.getLevel()>4){
            region.setLv5Code(region.getRegionId().substring(9,12));
            region.setLv5Name(regionReq.getLv5Name());
        }
        region.setFullName(getFullName(regionReq));
        region.setShortName(getShortName(regionReq));
        region.setIsActive(regionReq.getIsActive());
        region.setIsPoor(regionReq.getIsPoor());
        //事务
        TransactionStatus status = txManager.getTransaction(new DefaultTransactionDefinition());
        ResMessage resMessage = regionDao.addRegion(region);
//        添加成功发送mq
        if(resMessage.isSuccess()){
            RegionChangeEvent regionChangeEvent = new RegionChangeEvent();
            regionChangeEvent.setKey(region.getRegionId());
            regionChangeEvent.setOperation(RegionChangeEvent.Operation.Add);
            ArrayList<Region> arrayList = new ArrayList<>();
            arrayList.add(region);
            regionChangeEvent.setRegions(arrayList);
            try {
                template.convertAndSend(AmqpConfiguration.MSGQUEUE_DATA_LOADER, JSON.toJSONString(regionChangeEvent));
                txManager.commit(status);
            }catch (Exception e){
                if (!status.isCompleted())
                    txManager.rollback(status);
                return ResponseEntity.ok(new ResMessage(false,"发送mq失败，数据回滚"));
            }
        }
        return ResponseEntity.ok(resMessage);
    }
    public Boolean checkRegion(String regionId){
        return regionDao.checkRegionById(regionId);
    }
    private Region initRegionEntity(){
        Region region = new Region();
        region.setChgTime(new Timestamp(System.currentTimeMillis()));
        region.setIsActive(new Byte("1"));
        region.setIsPoor(new Byte("0"));
        return region;
    }
    private String getFullName(RegionReq regionReq){
        StringBuilder fullName = new StringBuilder();
        if(regionReq.getLv1Name()!=null)fullName.append(regionReq.getLv1Name());
        if(regionReq.getLv2Name()!=null)fullName.append(regionReq.getLv2Name());
        if(regionReq.getLv3Name()!=null)fullName.append(regionReq.getLv3Name());
        if(regionReq.getLv4Name()!=null)fullName.append(regionReq.getLv4Name());
        if(regionReq.getLv5Name()!=null)fullName.append(regionReq.getLv5Name());
        return fullName.toString();
    }
    private String getShortName(RegionReq regionReq){
        String shortName = null;
        switch (regionReq.getLevel()){
            case 1:shortName = regionReq.getLv1Name();break;
            case 2:shortName = regionReq.getLv2Name();break;
            case 3:shortName = regionReq.getLv3Name();break;
            case 4:shortName = regionReq.getLv4Name();break;
            case 5:shortName = regionReq.getLv5Name();break;
            default:shortName = "不限区域";
        }
        return shortName;
    }
}
