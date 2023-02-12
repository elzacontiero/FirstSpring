package com.sparta.firstspring.repositories;

import com.sparta.firstspring.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRepository extends JpaRepository<Staff, Short> {

    // query using JPQL
    @Query(value = "SELECT s FROM Staff s WHERE LENGTH(s.username) <4")
    List<Staff> findAllStaffWithShortNames();

    // query using SQL
    @Query(value = "SELECT * FROM staff s WHERE LENGTH (s.username) >3", nativeQuery = true)
    List<Staff> findAllStaffWithLongNameUsingSQL();

    @Query(value = "SELECT * FROM staff s WHERE LENGTH (s.username) >:usernameLength", nativeQuery = true)
    List<Staff> findAllStaffWithLongNameUsingSQL(Integer usernameLength);
}

