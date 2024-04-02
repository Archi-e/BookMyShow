package com.archie.BookMyShow.repository;

import com.archie.BookMyShow.model.City;
import com.archie.BookMyShow.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {
}
