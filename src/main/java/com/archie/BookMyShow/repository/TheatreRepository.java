package com.archie.BookMyShow.repository;

import com.archie.BookMyShow.model.City;
import com.archie.BookMyShow.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    public Theatre findByName(String name);
}
