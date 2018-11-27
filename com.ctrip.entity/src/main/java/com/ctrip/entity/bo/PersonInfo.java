package com.ctrip.entity.bo;

import java.util.Date;

/**
 * 成员信息
 */
public class PersonInfo {
    private Integer PersonId;

    private String personName;

    private Date datacreatTime;

    private Integer HomeId;


    private  Integer seceId;

    public Integer getSeceId() {
        return seceId;
    }

    public void setSeceId(Integer seceId) {
        this.seceId = seceId;
    }

    public Integer getPersonId() {
        return PersonId;
    }

    public HomeInformationBo getHomeInformationBo() {
        return homeInformationBo;
    }

    public void setHomeInformationBo(HomeInformationBo homeInformationBo) {
        this.homeInformationBo = homeInformationBo;
    }

    public HomeInformationBo homeInformationBo;

    public void setPersonId(Integer personId) {
        PersonId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Date getDatacreatTime() {
        return datacreatTime;
    }

    public void setDatacreatTime(Date datacreatTime) {
        this.datacreatTime = datacreatTime;
    }

    public Integer getHomeId() {
        return HomeId;
    }

    public void setHomeId(Integer homeId) {
        HomeId = homeId;
    }
}
