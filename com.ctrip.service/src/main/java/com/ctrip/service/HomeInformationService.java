package com.ctrip.service;

import com.ctrip.dao.mapper.HomeInformationMapper;
import com.ctrip.entity.bo.HomeInformationBo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeInformationService {

    @Autowired
    private HomeInformationMapper hotelInformationMapper;


    public HomeInformationBo getOneHomeInformation(Integer id) {
        return hotelInformationMapper.selectHomeInfo(id);
    }

}
