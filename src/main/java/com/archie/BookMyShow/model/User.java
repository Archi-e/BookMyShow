package com.archie.BookMyShow.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Table(name = "BMS_USER")
@Entity
public class User extends BaseModel{

    private String name;
    private String email;
    private String password;
    @OneToMany
    private List<Ticket> tickets;
}
