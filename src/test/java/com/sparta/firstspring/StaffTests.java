package com.sparta.firstspring;
import com.sparta.firstspring.entities.Address;
import com.sparta.firstspring.entities.Staff;
import com.sparta.firstspring.repositories.StaffRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;
import java.util.Optional;


@Transactional
@SpringBootTest
public class StaffTests {
    @Autowired
    private StaffRepository repo;

    @Test
    void contextLoads() {
    }

    @Test
    void testStaffAddress() {
        Optional<Staff> mikeOpt = repo.findById( (short) 1 );
        Staff mike = mikeOpt.get();
        Address mikesAddress = mike.getAddress();
        String district = mikesAddress.getDistrict();
        Assertions.assertEquals("Alberta", district);

    }

    @Test
    void testNameLengthQueries() {
        List<Staff>list = repo.findAllStaffWithShortNames();
        Assertions.assertTrue(list.size() ==1);

        List<Staff> result = repo.findAllStaffWithLongNameUsingSQL();
        System.out.println(result);
        Assertions.assertTrue(result.size() == 1);
    }

}
