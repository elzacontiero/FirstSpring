package com.sparta.firstspring;
import com.sparta.firstspring.entities.Actor;
import com.sparta.firstspring.repositories.ActorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@SpringBootTest // Tell Spring the class that follows is a Test for Spring.
public class ActorTests {
    @Test // defines a Test
    void contextLoads() {
    }

    @Autowired // no need to construct the object, it keeps track of the object constructing it for us.

    private ActorRepository repo; // repo is the object generated for us by the JPA hibernate system, it conforms to
                                 // the interface and the methods have been written automatically. Repo does the job of
                                 // communicating with the Database.


    // CRUD - Read from database
    @Test
    void testFindById() {
        Optional<Actor> result = repo.findById(15); // Actor object might or might not be there, that's the Optional.
        if (result.isPresent()) { // if we do have an Actor
            Actor cuba = result.get(); // get the Actor
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
        newActor.setId(0); // set to zero, but it will be ignored when saving. It is the database that will override 0
                           // and give the right id as a response.
        newActor.setFirstName("Mary");
        newActor.setLastName("George");
        newActor.setLastUpdate(Instant.now()); //set the last update to now.
        Actor result = repo.save(newActor); // Repo: save newActor to the database.
        System.out.println("Returned from save method: " + result);// result will be the update plus the id generated
                                                                    // in the database for this newActor.

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
        Assertions.assertTrue(resultBeforeDelete.isPresent());

        // DELETE that record
        repo.deleteById(result.getId());
        Optional<Actor> resultAfterDelete = repo.findById(result.getId());
        Assertions.assertFalse(resultAfterDelete.isPresent());
    }

//    @Test
//    //void testFindByLastName() {
//        List<Actor> result = repo.findByLastName("NICHOLSON");
//        System.out.println(result);
//        Assertions.assertTrue(result.size()>=1);
//    }

    @Test
    void testFindByLastName() {
        List<Actor> listOfActors = repo.findByLastName("GABLE");
        System.out.println(listOfActors);
        Assertions.assertEquals(1, listOfActors.size());
        Actor gable = listOfActors.get(0);
        Assertions.assertEquals("GABLE", gable.getLastName());
    }
}
