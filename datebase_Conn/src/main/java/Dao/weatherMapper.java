package Dao;
import pojo.weather;

import java.util.List;

public interface weatherMapper {
    List<weather> findByName(String name);
    List<weather> findById(int id);
    int save(weather weather);
    int update(weather weather);

}
