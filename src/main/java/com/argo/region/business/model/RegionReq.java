package com.argo.region.business.model;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 11:04
 *
 * @author hugh
 */
public class RegionReq {
    private String regionId;
    private int level;
    private String lv1Name;
    private String lv2Name;
    private String lv3Name;
    private String lv4Name;
    private String lv5Name;
    private Byte isActive = new Byte("1");
    private Byte isPoor= new Byte("0");

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLv1Name() {
        return lv1Name;
    }

    public void setLv1Name(String lv1Name) {
        this.lv1Name = lv1Name;
    }

    public String getLv2Name() {
        return lv2Name;
    }

    public void setLv2Name(String lv2Name) {
        this.lv2Name = lv2Name;
    }

    public String getLv3Name() {
        return lv3Name;
    }

    public void setLv3Name(String lv3Name) {
        this.lv3Name = lv3Name;
    }

    public String getLv4Name() {
        return lv4Name;
    }

    public void setLv4Name(String lv4Name) {
        this.lv4Name = lv4Name;
    }

    public String getLv5Name() {
        return lv5Name;
    }

    public void setLv5Name(String lv5Name) {
        this.lv5Name = lv5Name;
    }


    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Byte getIsPoor() {
        return isPoor;
    }

    public void setIsPoor(Byte isPoor) {
        this.isPoor = isPoor;
    }
}
