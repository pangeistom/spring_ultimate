package com.ctrip.service;

import com.ctrip.dao.mapper.PersonInfoMapper;
import com.ctrip.entity.bo.PersonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PersonInfoService {

    @Autowired
    private PersonInfoMapper personInfoMapper;

    public int inserPersonInfo() {
        for (int i = 0; i < 100; i++) {
            PersonInfo info = new PersonInfo();
            info.setDatacreatTime(new Date());
            info.setHomeId(i);
            info.setPersonName("张三");
            personInfoMapper.insertIntoPerson(info);
        }
        return 0;
    }

    public List<PersonInfo> getPersonList(){
        return personInfoMapper.getPersonList();
    }
}
