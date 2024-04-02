package com.archie.BookMyShow.controller;

import com.archie.BookMyShow.dto.CityRequestDTO;
import com.archie.BookMyShow.model.City;
import com.archie.BookMyShow.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CityController {
    @Autowired
    private CityService cityService;

    @GetMapping("/city/{name}")
    public ResponseEntity getCityByName(@PathVariable("name") String cityName){
        City city = cityService.getCityByName(cityName);
        return ResponseEntity.ok(city);
    }

    @PostMapping("/city")
    public ResponseEntity createCity(@RequestBody CityRequestDTO cityRequestDTO){
        try{
            String cityName = cityRequestDTO.getName();
            if(cityName == null || cityName.isBlank() || cityName.isEmpty()){
                throw new Exception("Invalid City Name");
            }
            City savedCity = cityService.saveCity(cityName);
            return ResponseEntity.ok(savedCity);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/city/{id}")
    public ResponseEntity deleteCity(@PathVariable("id") int id){
        boolean isDeleted = cityService.deleteCityById(id);
        return ResponseEntity.ok(isDeleted);
    }
}
