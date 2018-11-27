package com.ctrip.dao.mapper;

import com.ctrip.entity.bo.HomeInformationBo;

public interface HomeInformationMapper {

    HomeInformationBo selectHomeInfo(Integer id);
}
