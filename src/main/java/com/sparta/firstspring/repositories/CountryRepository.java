package com.sparta.firstspring.repositories;

import com.sparta.firstspring.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
    // some interfaces may not need an extra specialised method to query the database. Some others we provide with
    // a method to specialise a query to database just like in CityRepository.


}