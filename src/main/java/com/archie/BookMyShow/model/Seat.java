package com.archie.BookMyShow.model;

import com.archie.BookMyShow.model.constants.SeatStatus;
import com.archie.BookMyShow.model.constants.SeatType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel{
    @Column(name= "Audi_row")
    private int row;
    @Column(name= "Audi_col")
    private int col;
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    public Seat(){

    }

    public Seat(int row, int col, String seatNumber, SeatType seatType, SeatStatus seatStatus) {
        this.row = row;
        this.col = col;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }
}
