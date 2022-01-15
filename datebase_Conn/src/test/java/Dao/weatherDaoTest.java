package Dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import utils.MybatisUtils;
import pojo.weather;
public class weatherDaoTest {
    @Test
    public void test(){
        SqlSession sqlSession= MybatisUtils.getSession();
        weatherMapper weatherMapper=sqlSession.getMapper(Dao.weatherMapper.class);
        weather w1=new weather(1,"beijing","2022-1-15","5","-10","4");
        weatherMapper.update(w1);
        sqlSession.commit();
        sqlSession.close();
    }
}
