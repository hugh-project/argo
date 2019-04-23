package com.argo.region.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA
 * Date: 2019/4/22
 * Time: 10:37
 *
 * @author hugh
 */
@Entity
@Table(name = "region")
public class Region {
    private String regionId;
    private int level;
    private String lv1Code;
    private String lv1Name;
    private String lv2Code;
    private String lv2Name;
    private String lv3Code;
    private String lv3Name;
    private String lv4Code;
    private String lv4Name;
    private String lv5Code;
    private String lv5Name;
    private String fullName;
    private String shortName;
    private Byte isActive;
    private Byte isPoor;
    private String areaCode;
    private String postCode;
    private Timestamp chgTime;
    private Timestamp cfmTime;
    @Id
    @Column(name = "RGNID",length = 12,nullable = true)
    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
    @Column(name = "LEVEL",length = 11, nullable = true)
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    @Column(name = "LV1CODE",nullable = true,length = 2)
    public String getLv1Code() {
        return lv1Code;
    }

    public void setLv1Code(String lv1Code) {
        this.lv1Code = lv1Code;
    }
    @Column(name = "LV1NAME",nullable = true,length = 64)
    public String getLv1Name() {
        return lv1Name;
    }

    public void setLv1Name(String lv1Name) {
        this.lv1Name = lv1Name;
    }
    @Column(name = "LV2CODE",length = 2)
    public String getLv2Code() {
        return lv2Code;
    }

    public void setLv2Code(String lv2Code) {
        this.lv2Code = lv2Code;
    }
    @Column(name = "LV2NAME",length = 64)
    public String getLv2Name() {
        return lv2Name;
    }

    public void setLv2Name(String lv2Name) {
        this.lv2Name = lv2Name;
    }
    @Column(name = "LV3CODE",length = 2)
    public String getLv3Code() {
        return lv3Code;
    }

    public void setLv3Code(String lv3Code) {
        this.lv3Code = lv3Code;
    }
    @Column(name = "LV3NAME",length = 64)
    public String getLv3Name() {
        return lv3Name;
    }

    public void setLv3Name(String lv3Name) {
        this.lv3Name = lv3Name;
    }
    @Column(name = "LV4CODE",length = 3)
    public String getLv4Code() {
        return lv4Code;
    }

    public void setLv4Code(String lv4Code) {
        this.lv4Code = lv4Code;
    }
    @Column(name = "LV4NAME",length = 64)
    public String getLv4Name() {
        return lv4Name;
    }

    public void setLv4Name(String lv4Name) {
        this.lv4Name = lv4Name;
    }
    @Column(name = "LV5CODE",length = 3)
    public String getLv5Code() {
        return lv5Code;
    }

    public void setLv5Code(String lv5Code) {
        this.lv5Code = lv5Code;
    }
    @Column(name = "LV5NAME",length = 64)
    public String getLv5Name() {
        return lv5Name;
    }

    public void setLv5Name(String lv5Name) {
        this.lv5Name = lv5Name;
    }
    @Column(name = "FULLNAME",length = 500,nullable = true)
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    @Column(name = "SHORTNAME",length = 64,nullable = true)
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Column(name = "ISACTIVE",length = 1,nullable = true)
    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }
    @Column(name = "ISPOOR",length = 1,nullable = true)
    public Byte getIsPoor() {
        return isPoor;
    }
    public void setIsPoor(Byte isPoor) {
        this.isPoor = isPoor;
    }
    @Column(name = "AREACODE",length = 4)
    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }
    @Column(name = "POSTCODE",length = 6)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }
    @Column(name = "CHGTIME")

    public Timestamp getChgTime() {
        return chgTime;
    }

    public void setChgTime(Timestamp chgTime) {
        this.chgTime = chgTime;
    }
    @Column(name = "CFMTIME")
    public Timestamp getCfmTime() {
        return cfmTime;
    }

    public void setCfmTime(Timestamp cfmTime) {
        this.cfmTime = cfmTime;
    }
}
