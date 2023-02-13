package com.sparta.firstspring.utils;

import com.sparta.firstspring.dtos.StaffDTO;
import com.sparta.firstspring.entities.Address;
import com.sparta.firstspring.entities.Staff;

public class DTOConverter {
    public static StaffDTO toDTO(Staff staff) {
        StaffDTO sDto = new StaffDTO();
        sDto.setFirstName(staff.getFirstName());
        sDto.setLastName(staff.getLastName());
        Address add = staff.getAddress();
        sDto.setAddress(add.getAddress() + " " + add.getPostalCode() + " " + add.getDistrict());
        return sDto;
    }
}
