package com.argo.region.business.model;

import com.argo.region.business.entity.Region;

import java.util.List;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 16:24
 *
 * @author hugh
 */
public class RegionChangeEvent {
    private String key;
    private RegionChangeEvent.Operation operation;
    private List<Region> regions;

    public RegionChangeEvent() {
    }

    public RegionChangeEvent(RegionChangeEvent.Operation opr, List<Region> regions) {
        this.operation = opr;
        this.regions = regions;
    }

    public RegionChangeEvent.Operation getOperation() {
        return this.operation;
    }

    public void setOperation(RegionChangeEvent.Operation operation) {
        this.operation = operation;
    }

    public List<Region> getRegions() {
        return this.regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String toString() {
        return "RegionChangeEvent{key='" + this.key + '\'' + ", operation=" + this.operation + ", regions=" + this.regions + '}';
    }

    public static enum Operation {
        Add,
        Update,
        Delete;

        private Operation() {
        }
    }
}
