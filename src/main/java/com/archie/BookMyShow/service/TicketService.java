package com.archie.BookMyShow.service;

import com.archie.BookMyShow.model.ShowSeat;
import com.archie.BookMyShow.model.Ticket;
import com.archie.BookMyShow.model.constants.ShowSeatStatus;
import com.archie.BookMyShow.repository.TicketRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private ShowSeatService showSeatService;
    @Autowired
    private TicketRepository ticketRepository;
    public String greet(){
        return "HELLO WORLD!";
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTickets(List<Integer> showSeatIds, Integer userIds) throws Exception {
//        checkAndLock(showSeatIds);
        for(Integer showSeatId: showSeatIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new Exception("Seat is no longer available");
            }
        }

        for(Integer showSeatId: showSeatIds){
            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(showSeat);
        }
        startPayment(showSeatIds);
        return new Ticket();
    }

//    @Transactional(isolation = Isolation.SERIALIZABLE)
//    public void checkAndLock(List<Integer> showSeatIds) throws Exception {
//        for(Integer showSeatId: showSeatIds){
//            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
//            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
//                throw new Exception("Seat is no longer available");
//            }
//        }
//
//        for(Integer showSeatId: showSeatIds){
//            ShowSeat showSeat = showSeatService.getShowSeatById(showSeatId);
//            showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
//            showSeatService.saveShowSeat(showSeat);
//        }
//
//
//    }

    public boolean startPayment(List<Integer> showSeatIds){
        return true;
    }
}
