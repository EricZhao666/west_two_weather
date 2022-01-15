package Dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import pojo.City;
import utils.MybatisUtils;

import java.util.List;

public class CityDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession=MybatisUtils.getSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        City c1= new City(2,"fuzhou","000","111");
        cityDao.save(c1);
        System.out.println(c1);
        sqlSession.commit();

        sqlSession.close();

    }
}
