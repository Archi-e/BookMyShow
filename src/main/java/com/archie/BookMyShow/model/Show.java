package com.archie.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Table(name = "BMS_Show")
@Entity
public class Show extends BaseModel{

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany
    private List<ShowSeat> showSeat;

    public Show(LocalDateTime startTime, LocalDateTime endTime, Movie movie, Auditorium auditorium) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.movie = movie;
        this.auditorium = auditorium;
    }
}
