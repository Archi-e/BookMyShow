package com.archie.BookMyShow.controller;

import com.archie.BookMyShow.dto.BookTicketRequestDTO;
import com.archie.BookMyShow.model.ShowSeat;
import com.archie.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    TicketService ticketService;
    @GetMapping("/hello")
    public ResponseEntity greet(){
        String greet = ticketService.greet();
        return ResponseEntity.ok(greet);
    }

    @PostMapping("/ticket")
    public ResponseEntity bookTickets(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) throws Exception {
        return ResponseEntity.ok(
                ticketService.bookTickets(bookTicketRequestDTO.getShowSeatIds(), bookTicketRequestDTO.getUserId())
        );
    }
}
