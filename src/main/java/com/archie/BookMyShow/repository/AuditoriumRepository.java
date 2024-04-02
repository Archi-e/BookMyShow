package com.archie.BookMyShow.repository;

import com.archie.BookMyShow.model.Auditorium;
import com.archie.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
    public Auditorium findByName(String name);
}
