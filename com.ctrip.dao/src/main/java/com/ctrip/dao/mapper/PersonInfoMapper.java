package com.ctrip.dao.mapper;

import com.ctrip.entity.bo.PersonInfo;

import java.util.List;

public interface PersonInfoMapper {
    int insertIntoPerson(PersonInfo info);

    List<PersonInfo> getPersonList();
}
