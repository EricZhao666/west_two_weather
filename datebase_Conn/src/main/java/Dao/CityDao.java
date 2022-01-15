package Dao;

import pojo.City;

import java.util.List;

public interface CityDao {
    List<City> findAll();
    City findByName(String name);
    int save(City city);

}
