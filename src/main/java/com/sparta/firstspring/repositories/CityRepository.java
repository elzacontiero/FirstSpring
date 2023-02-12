package com.sparta.firstspring.repositories;

import com.sparta.firstspring.entities.City;
import com.sparta.firstspring.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    // if you want to find all the cities of a given country you create a specialized method.
    List<City> findCitiesByCountry(Country country);

}

