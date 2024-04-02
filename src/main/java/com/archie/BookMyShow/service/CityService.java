package com.archie.BookMyShow.service;

import com.archie.BookMyShow.model.City;
import com.archie.BookMyShow.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService {
    @Autowired
    CityRepository cityRepository;

    public City findCityById(int cityId){
        return cityRepository.findById(cityId).get();
    }
    public City getCityByName(String cityName){
        City city = cityRepository.findCityByName(cityName);
        return city;
    }
    public City saveCity(String cityName){
        City city = new City();
        city.setName(cityName);
        return cityRepository.save(city);
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public boolean deleteCityById(int id){
        cityRepository.deleteById(id);
        return true;
    }
}
