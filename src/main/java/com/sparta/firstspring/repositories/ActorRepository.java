package com.sparta.firstspring.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.sparta.firstspring.entities.Actor;

import java.util.List;
// package repositories is where you put your repositories. They are classes that talk to the Database.



// Interface ActorRepository extends the JpaRepository telling which model you want
// to talk to, in this case the Actor table.
// So, the Repository takes this model (Actor class) and exchanges data with the Database.

// How can I implement this interface if there aren't any methods?
// A: there are methods defined as we extended JpaRepository.

public interface ActorRepository extends JpaRepository<Actor, Integer> {

    // method findByLastName and returns the list of Actors.
    // Repository is the one responsible for talking to the database. It transforms the findByLastName and the parameter
    // into a SQL internally and sends it to the database and get back result as a list of actors.
    List<Actor> findByLastName(String lastName);

}