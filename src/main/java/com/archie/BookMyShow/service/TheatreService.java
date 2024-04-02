package com.archie.BookMyShow.service;

import com.archie.BookMyShow.model.City;
import com.archie.BookMyShow.model.Theatre;
import com.archie.BookMyShow.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityService cityService;

    public Theatre saveTheatre(String name, String address, int cityId){

        Theatre savedTheatre = new Theatre();
        savedTheatre.setName(name);
        savedTheatre.setAddress(address);

        theatreRepository.save(savedTheatre);

        City city = cityService.findCityById(cityId);
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);
        city.setTheatres(theatres);
        cityService.saveCity(city);

        return savedTheatre;
    }
}
