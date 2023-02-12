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
        System.out.println(list);
        Assertions.assertTrue(list.size() ==1);

        List<Staff> longList = repo.findAllStaffWithLongNameUsingSQL();
        System.out.println(longList);
        Assertions.assertTrue(longList.size() == 1);

        List<Staff> longList1 = repo.findAllStaffWithLongNameUsingSQL(3);
        System.out.println(longList1);
        Assertions.assertTrue(longList1.size() == 1);
    }

}
