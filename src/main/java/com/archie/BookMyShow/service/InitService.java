package com.archie.BookMyShow.service;

import com.archie.BookMyShow.model.*;
import com.archie.BookMyShow.model.constants.AuditoriumFeature;
import com.archie.BookMyShow.model.constants.SeatStatus;
import com.archie.BookMyShow.model.constants.SeatType;
import com.archie.BookMyShow.model.constants.ShowSeatStatus;
import com.archie.BookMyShow.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class InitService {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private AuditoriumRepository auditoriumRepository;
    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private UserRepository userRepository;

    public boolean initialise(){
        City delhi = new City("Delhi");
        City mumbai = new City("Mumbai");
        City chennai = new City("Chennai");

        cityRepository.save(delhi);
        cityRepository.save(mumbai);
        cityRepository.save(chennai);

        City savedCity = cityRepository.findCityByName("Delhi");
        Theatre theatre1 = new Theatre("D City", "Rajiv Gandhi Nagar");
        Theatre theatre2 = new Theatre("Millennium", "CP");

        theatreRepository.save(theatre1);
        theatreRepository.save(theatre2);

        Theatre savedTheatre1 = theatreRepository.findByName("D City");
        Theatre savedTheatre2 = theatreRepository.findByName("Millennium");


        List<Theatre> theatres= new ArrayList<>();
        theatres.add(savedTheatre1);
        theatres.add(savedTheatre2);
        savedCity.setTheatres(theatres);
        cityRepository.save(savedCity);

        for(int i=1;i<=5;i++){
            Seat s = new Seat(i, i, i+ " "+i, SeatType.GOLD, SeatStatus.AVAILABLE);
            seatRepository.save(s);
        }

        List<Seat> savedSeats = seatRepository.findAll();

        Auditorium auditorium = new Auditorium();
        auditorium.setName("Audi01");
        auditorium.setCapacity(5);
        auditorium.setSeats(savedSeats);
        auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.DOLBY, AuditoriumFeature.IMAX));
        auditoriumRepository.save(auditorium);

        Auditorium savedAuditorium = auditoriumRepository.findByName("Audi01");
        Theatre delhitheatre = theatreRepository.findByName("D City");
        List<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(savedAuditorium);
        delhitheatre.setAuditoriums(auditoriums);
        theatreRepository.save(delhitheatre);

        Movie movie = new Movie("Titanic", "best movie ever");
        movieRepository.save(movie);

        Show show = new Show(LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(180),
                movieRepository.findMovieByName("Titanic"),
                auditoriumRepository.findByName("Audi01"));

        showRepository.save(show);


        for(int i=1;i<=5;i++){
            ShowSeat s = new ShowSeat(1251,
                    showRepository.findById(1).get(),
                    seatRepository.findSeatBySeatNumber(i+" "+i),
                    ShowSeatStatus.AVAILABLE);
            showSeatRepository.save(s);
        }

        return true;

    }


}
