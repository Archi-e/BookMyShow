package com.archie.BookMyShow.repository;

import com.archie.BookMyShow.model.City;
import com.archie.BookMyShow.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    public Seat findSeatBySeatNumber(String seatNumber);
}
