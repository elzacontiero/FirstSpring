package com.sparta.firstspring;
import com.sparta.firstspring.entities.City;
import com.sparta.firstspring.entities.Country;
import com.sparta.firstspring.repositories.CityRepository;
import com.sparta.firstspring.repositories.CountryRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
public class CityTests {
    @Test
    void contextLoads() {
    }

    @Autowired
    private CityRepository repo; // repo is the object repository that talks to the database.
    @Autowired
    private CountryRepository repoCountry;

    @Test
    void testFindById() {
        Optional<City>  result = repo.findById(589); // pull a city from the database. I get back result.it is Optional you might get result or might not.
        Assertions.assertTrue(result.isPresent()); // if result is not present, test fails.
        City york = result.get(); // if it passes, get the city inside the optional.
        Assertions.assertEquals("York", york.getCity()); // Compare if what you expect is actually what you got.
        Country uk = york.getCountry();
        Assertions.assertEquals("United Kingdom", uk.getCountry());
    }

    @Test
    void testFindCitiesByCountry(){
        Optional<Country> result = repoCountry.findById(8);
        Assertions.assertTrue(result.isPresent());
        Country australia = result.get();
        Assertions.assertEquals("Australia", australia.getCountry());
        List<City> cities = repo.findCitiesByCountry(australia);
        Assertions.assertEquals(1, cities.size());
        City city = cities.get(0);
        Assertions.assertEquals("Woodridge", city.getCity());
    }

}

