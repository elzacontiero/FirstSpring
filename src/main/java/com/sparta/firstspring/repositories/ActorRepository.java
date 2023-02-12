package com.sparta.firstspring.repositories; // package repositories where you put all your repositories.
import org.springframework.data.jpa.repository.JpaRepository;
import com.sparta.firstspring.entities.Actor;

import java.util.List;


// How can I implement this interface if there aren't any methods?
// A: there are methods defined as we extended JpaRepository.


// ActorRepository is an interface that extends JpaRepository interface providing communication with the database
// for this entity Actor. So, ActorRepository talks to the Actor and talks to the Database where Actor table exists.
public interface ActorRepository extends JpaRepository<Actor, Integer> {

    // we can customise methods and add more like the one below. it will become queries to
    // the database, like findByLastName
    List<Actor> findByLastName(String lastName); //method findByLastName and returns the list of Actors.
                                                // It transforms the findByLastName parameter into a SQL internally
                                               //and sends it to the database and get back result as a list of actors.
}