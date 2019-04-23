package com.argo.region.business.model;

import com.argo.region.business.entity.Region;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 17:55
 *
 * @author hugh
 */
public class RegionPublishMessage implements Serializable {
    private int count;
    private String key;
    private LinkedList<Region> regions;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public LinkedList<Region> getRegions() {
        return regions;
    }

    public void setRegions(LinkedList<Region> regions) {
        this.regions = regions;
    }
}
