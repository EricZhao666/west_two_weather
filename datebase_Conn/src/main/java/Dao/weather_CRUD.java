package Dao;
import org.apache.ibatis.session.SqlSession;
import pojo.weather;
import utils.MybatisUtils;

import java.util.List;

public class weather_CRUD {
    //保存天气
    public  void saveWeather(weather weather){
        SqlSession sqlSession= MybatisUtils.getSession();
        weatherMapper weatherMapper=sqlSession.getMapper(Dao.weatherMapper.class);
        weatherMapper.save(weather);
        sqlSession.commit();
        sqlSession.close();
    }
    //查询城市天气
    public  void findByName(String name){
        SqlSession sqlSession= MybatisUtils.getSession();
        weatherMapper weatherMapper=sqlSession.getMapper(Dao.weatherMapper.class);
        List<weather> weatherList=weatherMapper.findByName(name);
        for (weather weather:weatherList) {
            System.out.println(weather);
        }
        sqlSession.close();

    }
    //更新天气
    public  void updateWeather(weather weather){
        SqlSession sqlSession= MybatisUtils.getSession();
        weatherMapper weatherMapper=sqlSession.getMapper(Dao.weatherMapper.class);
        weatherMapper.update(weather);
        sqlSession.commit();
        sqlSession.close();

    }
    public  List<weather> findById(int id){
        SqlSession sqlSession= MybatisUtils.getSession();
        weatherMapper weatherMapper=sqlSession.getMapper(Dao.weatherMapper.class);
        List<weather> weatherList=weatherMapper.findById(id);
        sqlSession.close();
        return weatherList;
    }

}
