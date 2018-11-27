package com.ctrip.web.controller;

import com.ctrip.entity.bo.HomeInformationBo;
import com.ctrip.entity.bo.PersonInfo;
import com.ctrip.entity.bo.User;
import com.ctrip.service.Cache.LocalCacheManager;
import com.ctrip.service.HomeInformationService;
import com.ctrip.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@RequestMapping("/first")
public class FirstController {


    @Autowired
    private HomeInformationService homeInformationService;

    @Autowired
    private PersonInfoService personInfoService;

    @Autowired
    private LocalCacheManager localCacheManager;


    @RequestMapping("first")
    public String first() {
        HomeInformationBo oneHomeInformation = homeInformationService.getOneHomeInformation(10);
        return "TATTY";
    }

    @RequestMapping("second")
    public String second() {


        Jedis jedis=new Jedis("118.190.151.160",6379);
        jedis.auth("123");
        
        jedis.set("wotat","朱攀");


        String wotat = jedis.get("wotat");



        String key = "firstkey";
        User user = new User();
        user.setAddress("中国");
        localCacheManager.setUserCache(key, user);
        User userCache = localCacheManager.getUserCache(key);
        personInfoService.inserPersonInfo();
        return "TATTY";
    }

    @RequestMapping("third")
    public String third() {
        HashSet<String> hashSet=new HashSet();
        hashSet.add("TTT");

        

        HashMap<String,String> hashMap=new HashMap<>();

        Map<String,String> hashMapt=new ConcurrentHashMap<>();

        hashMap.put("1", "1");

        Map treeMap=new TreeMap<String,String>();
        List<PersonInfo> personList = personInfoService.getPersonList();
        return "TATTY";
    }

}
