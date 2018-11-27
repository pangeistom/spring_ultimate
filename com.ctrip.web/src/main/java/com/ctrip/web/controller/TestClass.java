package com.ctrip.web.controller;

import com.ctrip.dao.mapper.HomeInformationMapper;
import com.ctrip.entity.bo.HomeInformationBo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

public class TestClass {

    @Test
    public void testMapper() throws Exception {
        // 加载核心配置文
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 执行Sql语句
        HomeInformationBo homeInfo = sqlSession.selectOne("selectHomeInfo", 10);

        HomeInformationBo homeInfo2 = sqlSession.selectOne("HotelInformation.selectHomeInfo", 10);

        List<HomeInformationBo> selectHomeList = sqlSession.selectList("selectHomeList", "123");

        HomeInformationBo homeInformationBo = new HomeInformationBo();
        homeInformationBo.setAddress("中国");
        homeInformationBo.setDatacreatTime(new Date());
        homeInformationBo.setPrice(109);
        int insertHomeInfo = sqlSession.insert("insertHomeInfo", homeInformationBo);
        sqlSession.commit();
        System.out.println(homeInformationBo.getHomeId());
    }

    @Test
    public void testMapper2() throws Exception {
        // 加载核心配置文
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        HomeInformationMapper mapper = sqlSession.getMapper(HomeInformationMapper.class);
        HomeInformationBo homeInformationBo = mapper.selectHomeInfo(10);
        System.out.println(homeInformationBo);

    }


    @Test
    public void testONe() throws InvocationTargetException, IllegalAccessException, NoSuchFieldException, InstantiationException, NoSuchMethodException {
        Class<HomeInformationBo> boClass = HomeInformationBo.class;
        Field[] fields = boClass.getFields();
        for (Field field : fields) {
            field.setAccessible(true);

        }
        HomeInformationBo homeInformationBo = boClass.newInstance();
        Field pubProperty = boClass.getField("pubProperty");
        pubProperty.setAccessible(true);
        pubProperty.set(homeInformationBo, "猪扒");
        boClass.getDeclaredFields();
        ClassLoader classLoader = boClass.getClassLoader();

        Method getTestMethodull = boClass.getDeclaredMethod("getTestMethod", String.class);
        getTestMethodull.setAccessible(true);
        getTestMethodull.invoke(homeInformationBo, "789");
        Method getTestMethod = boClass.getMethod("getTestMethod", String.class);
        getTestMethod.setAccessible(true);
        getTestMethod.invoke(homeInformationBo, "456");
    }
}
