package com.archie.BookMyShow.repository;

import com.archie.BookMyShow.model.Actor;
import com.archie.BookMyShow.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
