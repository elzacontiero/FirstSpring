package com.sparta.firstspring;
import com.sparta.firstspring.model.Actor;
import com.sparta.firstspring.repositories.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Instant;
import java.util.Optional;

@SpringBootTest
public class FirstSpringApplicationTests {
    @Test
    void contextLoads() {
    }

    @Autowired // we don't need to construct the object, it keep track of the object constructing
    // it for us.
    private ActorRepository repo;


    // my version
//    @Test
//    void testFindById() {
//        Optional<Actor> result = repo.findById(15);
//        Assertions.assertTrue(result.isPresent());
//        Actor cuba = result.get();
//        System.out.println(cuba); // uses Actor.toString()
//        Assertions.assertEquals("CUBA", cuba.getFirstName());
//        Assertions.assertEquals("OLIVIER", cuba.getLastName());
//    }

    // CRUD - Read from database
    @Test
    void testFindById() {
        Optional<Actor> result = repo.findById(15);
        if (result.isPresent()) { // we do have an Actor
            Actor cuba = result.get();
            Assertions.assertEquals("CUBA", cuba.getFirstName());
            Assertions.assertEquals("OLIVIER", cuba.getLastName());
        } else {
            Assertions.fail();
        }
    }

    // CRUD - Create an Actor on the database.
    @Test
    void testCreateActor() {
        Actor newActor = new Actor(); // Create the new Actor object
        newActor.setId(0);
        newActor.setFirstName("Mary");
        newActor.setLastName("George");
        newActor.setLastUpdate(Instant.now());
        // save it in the database.
        Actor result = repo.save(newActor);
        System.out.println("Returned from save method: " + result);

        // CRUD - Retrieve the new record from the database
        Optional<Actor> found = repo.findById(result.getId());
        Assertions.assertTrue(found.isPresent());
        Actor foundActor = found.get();
        // check that we have the correct actor back.
        System.out.println("Actor with id: "+ foundActor.getId() + " is " + foundActor);
        Assertions.assertEquals("Mary", foundActor.getFirstName());
    }


    // CRUD - Update Actor
    @Test
    void testUpdateActor() {
        Optional<Actor> result = repo.findById(70);
        if (result.isPresent()) {
            Actor actor = result.get();
            System.out.println("Before update: " + actor);
            actor.setFirstName("Matthew");
            System.out.println(actor);
            repo.save(actor);
        }
        else{
            Assertions.fail();
        }
         //Checking if Update was effective

        Optional<Actor> resultAfterUpdate = repo.findById(70);
        if (resultAfterUpdate.isPresent()) {
            Actor actor = resultAfterUpdate.get();
            System.out.println("After Update "+ actor);
            Assertions.assertEquals("Matthew", actor.getFirstName());
            actor.setFirstName("MICHELLE");
           repo.save(actor);
        }
        else{
            Assertions.fail();
        }
    }

    // CRUD - Delete Actor
    @Test
    void testDeleteActor() {
        // Create a new record that doesn't exist in the database.
        Actor newActor = new Actor();
        newActor.setId(0);
        newActor.setFirstName("Mary");
        newActor.setLastName("George");
        newActor.setLastUpdate(Instant.now());

        // save it in the database
        Actor result = repo.save(newActor);
        System.out.println(result);

        // find that record (the one we just made it and then delete it)
        Optional<Actor> resultBeforeDelete = repo.findById(result.getId());
        if(resultBeforeDelete.isEmpty()) Assertions.fail();

        // DELETE that record
        repo.deleteById(result.getId());
        Optional<Actor> resultAfterDelete = repo.findById(result.getId());
        Assertions.assertFalse(resultAfterDelete.isPresent());
    }

}
