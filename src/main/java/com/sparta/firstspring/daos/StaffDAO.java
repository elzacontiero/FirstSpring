package com.sparta.firstspring.daos;

import com.sparta.firstspring.dtos.StaffDTO;
import com.sparta.firstspring.entities.Address;
import com.sparta.firstspring.entities.Staff;
import com.sparta.firstspring.repositories.StaffRepository;
import com.sparta.firstspring.utils.DTOConverter;

import java.util.List;
import java.util.Optional;

public class StaffDAO {
    private StaffRepository repo;
    public StaffDAO(StaffRepository repo) {
        this.repo = repo;
    }

    public String getDistrict(short staffId) {
        Optional<Staff> mikeOpt = repo.findById((short)1);
        Staff mike = mikeOpt.get();
        Address mikesAddress = mike.getAddress();
        return mikesAddress.getDistrict();
    }

    public StaffDTO getStaffDTOByName(String firstName, String lastName) {
        List<Staff> staffList = repo.findByFirstNameAndLastName(firstName, lastName);
        if (staffList.size() != 1) {
            throw new RuntimeException("No unique staff member of that name");
        }
        return DTOConverter.toDTO(staffList.get(0));

    }
}
