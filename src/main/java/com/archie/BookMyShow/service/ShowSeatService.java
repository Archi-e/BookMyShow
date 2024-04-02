package com.archie.BookMyShow.service;

import com.archie.BookMyShow.model.ShowSeat;
import com.archie.BookMyShow.model.constants.ShowSeatStatus;
import com.archie.BookMyShow.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowSeatService {
    @Autowired
    ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeatById(int id){
        return showSeatRepository.findById(id).get();
    }

    public ShowSeat saveShowSeat(ShowSeat showSeat){
        return showSeatRepository.save(showSeat);
    }
}
