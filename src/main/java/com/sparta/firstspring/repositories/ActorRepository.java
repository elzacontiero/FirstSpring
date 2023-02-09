package com.sparta.firstspring.repositories;
import com.sparta.firstspring.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

// package repositories is where you put your repositories. They are classes that talk to the Database.
// Classes in the package Service makes uses of the repository classes.


// create an interface ActorRepository that extends the JpaRepository telling which model you
// want to talk to, in this case the Actor table.. The Integer would the be primary key?

// So, the Repository takes this model (Actor class in model) and exchange data with the Database.
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}