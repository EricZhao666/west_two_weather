package Dao;

import org.apache.ibatis.session.SqlSession;
import pojo.City;
import utils.MybatisUtils;

import java.util.List;

public class City_CRUD {
    //保存城市
    public void SaveCity(City city){
        SqlSession sqlSession= MybatisUtils.getSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        cityDao.save(city);
        sqlSession.commit();

        sqlSession.close();
    }
    //查找所有城市
    public void find_all(){
        SqlSession sqlSession= MybatisUtils.getSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        List<City> cityList=cityDao.findAll();
        for (City city:cityList) {
            System.out.println(city);
        }
    }
    //根据名字查找城市
    public void findByName(String name){
        SqlSession sqlSession= MybatisUtils.getSession();
        CityDao cityDao = sqlSession.getMapper(CityDao.class);
        City c1=cityDao.findByName(name);
        System.out.println(c1);
    }
}
